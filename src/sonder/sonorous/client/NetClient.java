package sonder.sonorous.client;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import sonder.sonorous.build.Meta;
import sonder.sonorous.build.Reflect;
import sonder.sonorous.network.Network;
import sonder.sonorous.resource.Log;

public class NetClient {
	
	//h_* indicates hashed varible
	private Client client;
	private Kryo kryo;
	private String h_password;
	
	public NetClient() {
		Log.write("Starting Sonorous client | version: " + Meta.VERSION);
		client = new Client();
		client.start();
		kryo = client.getKryo();
		Log.write("Client startup complete!");
	}
	
	public void connect(String server, String password) throws Exception {
		Log.write("Connecting to '" + server + "' over port " + Network.TCP_PORT);
		
		client.connect(5000, server, Network.TCP_PORT);
		
		if(client.isConnected()) {
			Log.write("Connection to remote server!");
			Log.write("Attempting authentication...");
			this.listen();
		} else {
			Log.write("Connection failed!");
		}
		
	}
	
	public void listen() {
		client.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		    	  if(object instanceof Reflect) {
		    		  Log.write("Reflect: " + ((Reflect)object).getReflection());
		    	  }
		    	  
		          if(object instanceof Byte) {
		             //Check docs for byte codes
		        	 byte code = (Byte)object;
		        	 switch(code) {
		        	 	case 0x00: //error code
		        	 	case 0x01: //server killed connection (planned)
		        	 	case 0x02: //server killed connection (unplanned)
		        	 	case 0x10: //server requesting authentication
		        	 	case 0x11: 
		        	 		//authentication success
		        	 		Log.write("Server accepted authentication!");
		        	 		break;
		        	 	case 0x12: //authentication denied
		        	 	default: 
		        	 }
		          }
		       }
		});
	}
	
	public void rawSend(Object raw) {
		client.sendTCP(raw);
	}
	
	public void register(Class c) {
		kryo.register(c);
		Log.write("Registered object/" + c.getName());
	}

}
