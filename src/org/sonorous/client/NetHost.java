package org.sonorous.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import org.sonorous.shared.Log;
import org.sonorous.shared.NSAppend;
import org.sonorous.shared.Network;
import org.sonorous.shared.State;
import com.esotericsoftware.kryonet.Server;

public class NetHost {
	
	private Server server;
	private boolean clientHookStatus;
	public State status;
	public NetClient hook;
	
	public NetHost() throws Exception {
		hook = null;
		clientHookStatus = false;
		server = new Server();
		server.start();
	    server.bind(Network.NAMESERVER_TCP);
	    Log.write("Host server started");
	}
	
	public void createRoom(String roomName, String roomPassword, String nameServer) throws Exception {
		String ip = this.getIP();
		NSAppend nsobj = new NSAppend(roomName, roomPassword, new String(Base64.encodeBase64(ip.getBytes())));
		
		if(clientHookStatus) {
			hook.hookHostAppend(nameServer, nsobj);
		}
	}
	
	public void hookClient(NetClient hook) {
		this.hook = hook;
		Log.write("Hooked client to host server");
		clientHookStatus = true;
	}
	
	private String getIP() throws Exception {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine();
		return ip;
	}

}
