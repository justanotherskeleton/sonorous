package org.sonorous.shared;

import org.apache.commons.codec.binary.Base64;

public class AuthBlock {
	
	//the authblock is a long base 64 string consisting of the ip and some mixed security info or random bits
	//This class DOES NOT get serialized or sent over the network, it is static for creation of auth block strings
	//the extra string is user provided numbers words whatever to add into the block
	
	//THIS SECURITY NEEDS TO BE FIXED
	
	public static String create(String ip) {
		return Base64.encodeBase64String(ip.getBytes());
	}
	
	public static String getIP(String b64) {
		return new String(Base64.decodeBase64(b64));
	}

}
