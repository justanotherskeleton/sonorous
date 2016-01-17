package sonder.sonorous.server;

import java.io.IOException;
import java.util.LinkedList;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import sonder.sonorous.build.Reflect;
import sonder.sonorous.network.Conn;
import sonder.sonorous.network.Message;
import sonder.sonorous.network.Network;
import sonder.sonorous.resource.Log;

public class NetServer {
	
	private Server server;
	private Kryo kryo;
	private Configuration config;
	private String h_password;
	private LinkedList<User> users;
	
	public NetServer() throws Exception {
		Log.write("Starting server @ " + Network.PUBLIC_IP);
		server = new Server();
	    server.start();
	    config = new Configuration();
	    config.init();
	    kryo = server.getKryo();
	    server.bind(Network.TCP_PORT);
	    Log.write("Server started!");
	}
	
	public void listen() {
		Log.write("Starting listening!");
		server.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		    	  //unit test
		          if (object instanceof Reflect) {
		             Reflect test_object = (Reflect)object;
		             Log.write("Reflect: " + test_object.reflection);
		             Reflect response = new Reflect("Received reflection object!");
		             server.sendToTCP(connection.getID(), response);
		          }
		          
		          //production
		          if(object instanceof Conn) {
		        	  Conn conn = (Conn)object;
		        	  if((conn.password).equals(h_password)) {
		        		  User newUser = new User();
		        		  newUser.setConn(connection);
		        		  newUser.setName(conn.name);
		        		  users.add(newUser);
		        		  Log.write("Accepted new user! ip:" + connection.getRemoteAddressTCP().getAddress().toString() + "/ name:" + newUser.getName());
		        		  server.sendToTCP(connection.getID(), 0x11);
		        	  } else {
		        		  Log.write("Denied user ip:" + connection.getRemoteAddressTCP().getAddress().toString());
		        		  server.sendToTCP(connection.getID(), 0x12);
		        		  server.sendToTCP(connection.getID(), 0x01);
		        		  connection.close();
		        	  }
		          }
		          
		          if(object instanceof Message) {
		        	  for(User u : users) {
		        		  server.sendToTCP(u.getConn().getID(), object);
		        	  }
		          }
		       }
		});
	}
	
	public void register(Class c) {
		kryo.register(c);
		Log.write("Registered object/" + c.getName());
	}

}
