package org.sonorous.client;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

import org.sonorous.shared.*;

public class NetClient {
	
	private Client client;
	public State status;
	
	public NetClient() {
		status = State.OFFLINE;
		Log.write("Client created");
		client = new Client();
		client.start();
		status = State.WAITING;
		Log.write("Client initialization complete");
	}
	
	public void enterRoom(String nameServer, String room, String password) throws Exception {
		Log.write("Attempting to connect to a Name Server @ " + nameServer);
		client.connect(5000, nameServer, Network.NAMESERVER_TCP);
		Log.write("Connection successful, submitting authentication...");
		
		String[] crypto_detail = Crypto.PBKDF2(password);
		NSAuthentication ns_auth = new NSAuthentication(room, crypto_detail[1], crypto_detail[0]);
		client.sendTCP(ns_auth);
		this.listenNameServer();
	}
	
	public void listenNameServer() {
		client.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		          if (object instanceof RoomData) {
		             
		          }
		       }
		});
	}

}
