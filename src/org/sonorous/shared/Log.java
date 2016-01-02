package org.sonorous.shared;

import java.awt.TextArea;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Log {
	
	public static LinkedList<TextArea> appendTo = new LinkedList<TextArea>();
	
	public static void write(String output) {
		System.out.println("[" + Log.getTimestamp() + "] " + output);
		for(TextArea ta : appendTo) {
			ta.append("[" + Log.getTimestamp() + "] " + output);
		}
	}
	
	public static String getTimestamp() {
		return new String(new SimpleDateFormat("HH.mm.ss").format(new Date()));
	}
	
	public static String getFullTimestamp() {
		return new String(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
	}

}
