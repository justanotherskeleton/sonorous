package sonder.sonorous.build;

import sonder.sonorous.network.Network;
import sonder.sonorous.resource.Crypto;
import sonder.sonorous.server.NetServer;

public class Server {
	
	public static void main(String args[]) throws Exception {
		Network.init();
		Crypto.init();
		Server server = new Server();
		boolean regt = Boolean.parseBoolean(args[0]);
		server.start(regt);
	}
	
	public void start(boolean registerTest) throws Exception {
		NetServer server = new NetServer();
		
		if(registerTest) {
			server.register(byte.class);
			server.register(Reflect.class);
		}
		
		server.listen();
	}

}
