package org.sonorous.client;

import com.esotericsoftware.kryonet.Client;
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

}
