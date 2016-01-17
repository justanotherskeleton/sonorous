package sonder.sonorous.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import sonder.sonorous.resource.Log;

public class Configuration {
	
	public String h_password, displayName; 
	public boolean displayIP, fileTransferAllowed, anonymousAllowed;
	public int maxConnections;
	private File config;
	
	public Configuration() {
		config = new File("config.json");
	}
	
	public void init() throws Exception {
		if(!config.exists()) {
			Log.write("config.json not found in running directory, defaulting settings!");
			configureDefault();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(config));
		Gson gson = new Gson();
		Configuration read = gson.fromJson(br, Configuration.class);
		this.configureWith(read);
		Log.write("Configured from existing file.");
	}
	
	public void configureDefault() throws Exception {
		Log.write("Defaulting server settings...");
		Configuration def = new Configuration();
		def.h_password = "::RESET PASSWORD::";
		def.displayName = "Sonorous Listen Server";
		def.displayIP = false;
		def.fileTransferAllowed = true;
		def.anonymousAllowed = false;
		def.maxConnections = 100;
		this.configureWith(def);
	}
	
	public void configureWith(Configuration read) {
		this.h_password = read.h_password;
		this.displayName = read.displayName;
		this.displayIP = read.displayIP;
		this.fileTransferAllowed = read.fileTransferAllowed;
		this.anonymousAllowed = read.anonymousAllowed;
		this.maxConnections = read.maxConnections;
	}
	
	public void writeConfiguration(Configuration update) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(config));
		Gson gson = new Gson();
		String append = gson.toJson(update);
		bw.write(append);
		Log.write("Rewrote config.json with new varibles!");
	}

}
