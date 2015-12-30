package org.sonorous.shared;

import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Crypto {
	
	public static String[] PBKDF2(String input) throws Exception {
		byte[] salt = new byte[16];
		new Random().nextBytes(salt);
		KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 128);
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = f.generateSecret(spec).getEncoded();
		Base64.Encoder enc = Base64.getEncoder();
		String str_salt = enc.encodeToString(salt);
		String str_hash = enc.encodeToString(hash);
		return new String[] { str_salt, str_hash }; 
	}

}
