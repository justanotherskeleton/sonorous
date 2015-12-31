package org.sonorous.client;

public class NetHookStatic {
	
	public static boolean operationComplete = false;

	public static boolean isOperationComplete() {
		return operationComplete;
	}

	public static void setOperationComplete(boolean operationComplete) {
		NetHookStatic.operationComplete = operationComplete;
	}

}
