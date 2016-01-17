package sonder.sonorous.resource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.jasypt.util.text.BasicTextEncryptor;

public class Crypto {
	
	private static BasicTextEncryptor enc;
	
	//sha256 hash encoded base 64
	public static String sha256(String input) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(input.getBytes("UTF-8"));
		byte[] hash = digest.digest();
		return Base64.encodeBase64String(hash);
	}
	
	//output base64
	public static String encrypt(String input) {
		return enc.encrypt(input);
	}
	
	public static String decrypt(String input) {
		return enc.decrypt(input);
	}
	
	public static void init() {
		enc = new BasicTextEncryptor();
		Log.write("Started crypto module!");
	}
	
	public static void setKey(String key) {
		enc.setPassword(key);
		Log.write("New encryption key set!");
	}

}
