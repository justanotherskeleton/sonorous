package org.sonorous.build;

public class Sonorous {
	
	public static void main(String[] args) {
		if(!(args.length == 1)) {
			System.out.println("Invalid amount of arguments");
		}
		
		Data.OS = System.getProperty("os.name");
	}

}
