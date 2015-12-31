package org.sonorous.shared;

public class NSAppend {
	
	public String roomName, roomPass, roomAuthBlock;
	
	public NSAppend(String roomName, String roomPass, String roomAuthBlock) {
		this.roomName = roomName;
		this.roomPass = roomPass;
		this.roomAuthBlock = roomAuthBlock;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomPass() {
		return roomPass;
	}

	public void setRoomPass(String roomPass) {
		this.roomPass = roomPass;
	}

	public String getRoomAuthBlock() {
		return roomAuthBlock;
	}

	public void setRoomAuthBlock(String roomAuthBlock) {
		this.roomAuthBlock = roomAuthBlock;
	}

}
