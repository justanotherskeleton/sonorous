package sonder.sonorous.build;

import java.util.Scanner;

import sonder.sonorous.network.*;
import sonder.sonorous.resource.Crypto;
import sonder.sonorous.resource.Log;
import sonder.sonorous.server.Configuration;
import sonder.sonorous.server.NetServer;

public class Server {
	
	public static void main(String args[]) throws Exception {
		Network.init();
		Crypto.init();
		Server server = new Server();
		
		if(args[0] != null) {
			if(args[0].equalsIgnoreCase("passwd")) {
				Log.write("[CLI PASSWD UTILITY]");
				Log.write("Enter in a new password:");
				Scanner in = new Scanner(System.in);
				String p_1 = in.nextLine();
				Log.write("Reenter the password");
				String p_2 = in.nextLine();
				if(p_1.equals(p_2)) {
					String h_password = Crypto.sha256(p_1);
					Configuration current = new Configuration();
					current.init();
					current.h_password = h_password;
					current.writeConfiguration(current);
					Log.write("Rewrote password successfully");
					System.exit(0);
				} else {
					Log.write("Passwords are not equal, exitting...");
					System.exit(-1);
				}
			}
		}
	}
	
	public void start() throws Exception {
		NetServer server = new NetServer();
		server.register(byte.class);
		server.register(Reflect.class);
		server.register(Message.class);
		server.register(Conn.class);
		
		server.listen();
	}

}
