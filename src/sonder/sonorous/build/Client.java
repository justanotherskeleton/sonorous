package sonder.sonorous.build;

import java.util.Scanner;

import sonder.sonorous.client.NetClient;
import sonder.sonorous.network.Conn;
import sonder.sonorous.network.Message;
import sonder.sonorous.network.Network;
import sonder.sonorous.resource.Crypto;
import sonder.sonorous.resource.Log;

public class Client {
	
	public boolean CLI_RUN = false;
	
	public static void main(String args[]) throws Exception {
		Network.init();
		Crypto.init();
		Client client = new Client();
		if(args[0] != null) {
			if(args[0].equalsIgnoreCase("reflect")) {
				client.t_Reflect(args[1]);
			} 	else if(args[0].equalsIgnoreCase("cli")) {
				client.t_cli(args[1], args[3], args[2]);
			}
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
	
	public void t_cli(String server, String name, String password) throws Exception {
		CLI_RUN = true;
		Log.write("[CLI MESSAGE ONLY, NOT FOR PRODUCTION PURPOSES]");
		NetClient nc = new NetClient();
		nc.register(byte.class);
		nc.register(Conn.class);
		nc.register(Message.class);
		nc.connect(server, password, name);
		Scanner scan = new Scanner(System.in);
		
		while(CLI_RUN) {
			String input = scan.nextLine();
			
			if(input.equalsIgnoreCase(":quit")) {
				CLI_RUN = false;
			}
			
			nc.sendMessage(input);
		}
	}

}
