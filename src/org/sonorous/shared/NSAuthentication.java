package org.sonorous.shared;

public class NSAuthentication {
	
	public String roomID, roomPassword, salt;
	
	public NSAuthentication(String roomID, String roomPassword, String salt) {
		this.roomID = roomID;
		this.roomPassword = roomPassword;
		this.salt = salt;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomPassword() {
		return roomPassword;
	}

	public void setRoomPassword(String roomPassword) {
		this.roomPassword = roomPassword;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
