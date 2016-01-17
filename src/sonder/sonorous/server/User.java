package sonder.sonorous.server;

import com.esotericsoftware.kryonet.Connection;

public class User {
	
	public Connection conn;
	public String name;
	
	public User() {}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
