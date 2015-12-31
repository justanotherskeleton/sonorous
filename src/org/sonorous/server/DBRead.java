package org.sonorous.server;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class DBRead implements Callable<String> {

	private String db_id, db_pass;
	public Scanner db_read;
	
	public DBRead(String db_id, String db_pass, Scanner db_read) {
		this.db_id = db_id;
		this.db_pass = db_pass;
		this.db_read = db_read;
	}
	
	@Override
	public String call() {
		while (db_read.hasNextLine()) {
			   final String db_currentLine = db_read.nextLine();
			   if(db_currentLine.contains(db_id)) { 
				   List<String> db_entries = Arrays.asList(db_currentLine.split(":::"));
				   if(db_pass.equals(db_entries.get(1))) {
					   return db_entries.get(2);
				   } else {
					   return "Invalid password";
				   }
			   }
		}
		
		return "Invalid entry";
	}
	
	

}
