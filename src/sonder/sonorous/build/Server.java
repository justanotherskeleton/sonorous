package sonder.sonorous.build;

import sonder.sonorous.server.NetServer;

public class Server {
	
	public static void main(String args[]) throws Exception {
		Server server = new Server();
		boolean regt = Boolean.parseBoolean(args[0]);
		server.start(regt);
	}
	
	public void start(boolean registerTest) throws Exception {
		NetServer server = new NetServer();
		server.listen();
	}

}
