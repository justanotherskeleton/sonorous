package org.sonorous.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.sonorous.shared.GenericSuccess;
import org.sonorous.shared.Log;
import org.sonorous.shared.NSAppend;
import org.sonorous.shared.NSAuthentication;
import org.sonorous.shared.Network;
import org.sonorous.shared.State;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class NetServer {
	
	private Server server;
	private Path db_file;
	private Charset db_charset = Charset.forName("UTF-8");
	private String db_head = new String(":::[SONOROUS DATABASE]");
	private BufferedWriter db_bwriter;
	private Scanner db_read;
	public State status;
	
	public NetServer() throws Exception {
		status = State.OFFLINE;
		server = new Server();
		server.start();
	    server.bind(Network.NAMESERVER_TCP);
	    db_file = Paths.get("sonorous.db");
		Log.write("Name Server initialized");
		status = State.ACTIVE;
		manageDB();
		listen();
	}
	
	//Requires Java 7+ (note on website)
	private void manageDB() throws Exception {
		//Temporary file object of db_file
		File database = db_file.toFile();
		boolean wasCreated = false;
		
		if(!database.exists()) {
			database.createNewFile();
			wasCreated = true;
			Log.write("No existing database found, created 'sonorous.db'");
		}
		db_bwriter = Files.newBufferedWriter(db_file, db_charset, StandardOpenOption.APPEND);
		
		if(wasCreated) {
			db_bwriter.write(db_head);
		}
		
		db_read = new Scanner(database);
		
		Log.write("Database check successfully completed, starting listen server");
	}
	
	private void listen() {
		server.addListener(new Listener() {
		       public void received (Connection connection, Object object) {
		          if (object instanceof NSAuthentication) {
		             NSAuthentication nsobj = (NSAuthentication)object;
		             final ExecutorService service;
		             final Future<String>  task;
		             service = Executors.newFixedThreadPool(1);        
		             task = service.submit(new DBRead(nsobj.getRoomID(), nsobj.getRoomPassword(), db_read));
		             String db_result = null;
		             try {
						db_result = task.get();
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
		             
		             //WARNING SUPER INSECURE AUTH BLOCK SENT IN BASE 64 WITH NO OTHER SECURITY
		             server.sendToTCP(connection.getID(), db_result);
		          }
		          
		          if(object instanceof NSAppend) {
		        	  NSAppend nsobj = (NSAppend)object;
		        	  try {
						appendDB(nsobj.getRoomName(), nsobj.getRoomPass(), nsobj.getRoomAuthBlock());
					} catch (Exception e) {
						e.printStackTrace();
					}
		        	  
		        	  server.sendToTCP(connection.getID(), new GenericSuccess());
		          }
		       }
		});
	}
	
	private void appendDB(String db_id, String db_pass, String db_authblock) throws Exception {
		db_bwriter.write(db_id + ":::" + db_pass + ":::" + db_authblock);
	}

}
