package org.sonorous.client;

import java.util.concurrent.Callable;

import org.sonorous.shared.Log;
import org.sonorous.shared.NSAppend;
import org.sonorous.shared.Network;

public class NetHook implements Callable<Boolean> {

	private String nameServer;
	public NetClient actor;
	protected NSAppend nsobj;
	
	public NetHook(String nameServer, NetClient actor, NSAppend nsobj) {
		this.nameServer = nameServer;
		this.actor = actor;
		this.nsobj = nsobj;
		try {
			this.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Boolean call() throws Exception {
		Log.write("Attempting to connect to a Name Server @ " + nameServer);
		actor.client.connect(5000, nameServer, Network.NAMESERVER_TCP);
		Log.write("Connection successful, appending room data from host hook");
		actor.client.sendTCP(nsobj);
		int clock = 0;
		
		//give server 100 seconds to respond
		while(clock <= 100) {
			if(NetHookStatic.isOperationComplete()) {
				return Boolean.TRUE;
			} else {
				Thread.sleep(100);
				clock++;
			}
		}
		
		return Boolean.FALSE;
	}
	
	

}
