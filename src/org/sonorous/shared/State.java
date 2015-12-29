package org.sonorous.shared;

public class State {
	
	public static State ACTIVE = new State();
	public static State WAITING = new State();
	public static State OFFLINE = new State();
	public static State MALFUNCTION = new State();
	
	public State() {
		
	}

}
