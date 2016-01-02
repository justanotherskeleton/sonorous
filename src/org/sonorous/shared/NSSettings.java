package org.sonorous.shared;

public class NSSettings {
	
	public boolean loggingAllowed, filesAllowed;
	public double maxFileSize; //in megabytes
	
	public NSSettings() {
		
	}
	
	public NSSettings(boolean log, boolean files, double fsize) {
		this.loggingAllowed = log;
		this.filesAllowed = files;
		this.maxFileSize = fsize;
	}

	public boolean isLoggingAllowed() {
		return loggingAllowed;
	}

	public void setLoggingAllowed(boolean loggingAllowed) {
		this.loggingAllowed = loggingAllowed;
	}

	public boolean isFilesAllowed() {
		return filesAllowed;
	}

	public void setFilesAllowed(boolean filesAllowed) {
		this.filesAllowed = filesAllowed;
	}

	public double getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(double maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

}
