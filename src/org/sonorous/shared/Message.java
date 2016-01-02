package org.sonorous.shared;

public class Message {
	
	public String source, text, stamp;
	public boolean isFile;
	
	public Message(String source, String text, String stamp, boolean isFile) {
		this.source = source;
		this.text = text;
		this.stamp = stamp;
		this.isFile = isFile;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}

	public boolean isFile() {
		return isFile;
	}

	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
}
