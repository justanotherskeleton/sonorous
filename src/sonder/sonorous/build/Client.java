package sonder.sonorous.build;

import sonder.sonorous.client.NetClient;
import sonder.sonorous.network.Network;
import sonder.sonorous.resource.Crypto;
import sonder.sonorous.resource.Log;

public class Client {
	
	public static void main(String args[]) throws Exception {
		Network.init();
		Crypto.init();
		Client client = new Client();
		if(args[0].equalsIgnoreCase("reflect")) {
			client.t_Reflect(args[1]);
		}
	}
	
	public void t_Reflect(String server) throws Exception {
		NetClient nc = new NetClient();
		nc.register(byte.class);
		nc.register(Reflect.class);
		nc.connect(server, "", "t_Reflect");
		Log.write("Sending reflection packet...");
		nc.rawSend(new Reflect("howdy server!"));
	}
	
	public void t_cli(String server, String name, String password) {
		
	}

}
