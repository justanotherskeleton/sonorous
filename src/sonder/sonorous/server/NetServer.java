package sonder.sonorous.server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import sonder.sonorous.build.Reflect;
import sonder.sonorous.network.Network;
import sonder.sonorous.resource.Log;

public class NetServer {
	
	private Server server;
	
	public NetServer() throws Exception {
		Log.write("Starting server @ " + Network.PUBLIC_IP);
		server = new Server();
	    server.start();
	    server.bind(Network.TCP_PORT);
	    Log.write("Server started!");
	}
	
	public void listen() {
		Log.write("Starting listening!");
		server.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		          if (object instanceof Reflect) {
		             Reflect test_object = (Reflect)object;
		             Log.write("Reflect: " + test_object.reflection);
		             Reflect response = new Reflect("Received reflection object!");
		             server.sendToTCP(connection.getID(), response);
		          }
		       }
		});
	}

}
