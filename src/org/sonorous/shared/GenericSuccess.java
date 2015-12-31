package org.sonorous.shared;

public class GenericSuccess {
	
	/*0 or null = really is generic...
	 * 1 = NetHook append thread success 
	 * 
	 */
	
	public int code;
	
	public GenericSuccess() {
		this.code = 0;
	}
	
	public GenericSuccess(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}

}
