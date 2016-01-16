package sonder.sonorous.resource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class Crypto {
	
	//sha256 hash encoded base 64
	public static String sha256(String input) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(input.getBytes("UTF-8"));
		byte[] hash = digest.digest();
		return Base64.encodeBase64String(hash);
	}

}
