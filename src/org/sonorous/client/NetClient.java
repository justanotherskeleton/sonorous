package org.sonorous.client;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.sonorous.server.DBRead;
import org.sonorous.shared.*;

public class NetClient {
	
	protected Client client;
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
		          if(object instanceof GenericSuccess) {
		        	  GenericSuccess gsobj = (GenericSuccess)object;
		        	  if(gsobj.getCode() == 0) {
		        		  
		        	  }
		        	  
		        	  if(gsobj.getCode() == 1) {
		        		  NetHookStatic.setOperationComplete(true);
		        	  }
		          }
		       }
		});
	}
	
	public void hookHostAppend(String nameServer, NSAppend nsobj) throws Exception {
		final ExecutorService service;
        final Future<Boolean>  task;
        service = Executors.newFixedThreadPool(1);        
        task = service.submit(new NetHook(nameServer, this, nsobj));
        Boolean result = null;
        try {
			result = task.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
        
        if(result = Boolean.TRUE) {
        	Log.write("Name server returned GS_1 (append to database successful)");
        } else if(result = Boolean.FALSE) {
        	Log.write("Name server did not respond within 10 seconds");
        } else {
        	Log.write("This message should never be seen, hook return null or invalid boolean. Serious error occured");
        }
	}

}
