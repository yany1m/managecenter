package com.runrong.managecenter.common.util;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CryptHelper {
	private static final char[] HEXES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static final String EMPTY_STRING = "";
	private static final byte[] ROW_BYTES = "80e36e39f34e678c".getBytes();

	public static String trim(String value) {
		return value == null ? null : value.trim();
	}

	public static boolean isEmpty(String value) {
		int length;
		if ((value == null) || ((length = value.length()) == 0))
			return true;
		for (int index = 0; index < length; index++) {
			char ch = value.charAt(index);
			if ((ch != ' ') && (ch != ' ') && (!Character.isISOControl(ch))) {
				return false;
			}
		}
		return true;
	}

	public static String digest(String content) throws Throwable {
		if (isEmpty(content)) {
			return content;
		}
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] ciphertext = digest.digest(content.getBytes());
		char[] chars = new char[ciphertext.length + ciphertext.length];
		int i = 0;
		for (byte element : ciphertext) {
			chars[(i++)] = HEXES[(element & 0xF)];
			chars[(i++)] = HEXES[(element >> 4 & 0xF)];
		}
		return new String(chars);
	}

	public static String encode(String content) throws Throwable {
		if (isEmpty(content)) {
			return content;
		}
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec keySpec = new SecretKeySpec(ROW_BYTES, "AES");
		cipher.init(1, keySpec);
		byte[] ciphertext = cipher.doFinal(content.getBytes());
		return Base64.encodeBase64String(ciphertext);
	}

	public static String decode(String content) throws Throwable {
		if (isEmpty(content)) {
			return content;
		}
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec keySpec = new SecretKeySpec(ROW_BYTES, "AES");
		cipher.init(2, keySpec);
		byte[] ciphertext = cipher.doFinal(Base64.decodeBase64(content));
		return new String(ciphertext);
	}

	public static String truncation(String string, int maxLength) {
		if (isEmpty(string))
			return "";
		try {
			StringBuilder out = new StringBuilder();
			truncation(out, string, maxLength, null);
			return out.toString();
		} catch (IOException e) {
		}
		return "";
	}

	public static String truncation(String string, int maxLength, String replace) {
		if (isEmpty(string))
			return "";
		try {
			StringBuilder out = new StringBuilder();
			truncation(out, string, maxLength, replace);
			return out.toString();
		} catch (IOException e) {
		}
		return "";
	}

	public static void truncation(Appendable out, String string, int maxLength) throws IOException {
		truncation(out, string, maxLength, null);
	}

	public static void truncation(Appendable out, String string, int maxLength, String replace) throws IOException {
		if ((isEmpty(string)) || (maxLength <= 0)) {
			return;
		}
		if (isEmpty(replace)) {
			replace = "...";
		}
		int index = 0;
		int end = Math.min(string.length(), maxLength);
		for (; index < end; index++) {
			out.append(string.charAt(index));
		}
		if (string.length() > maxLength)
			out.append(replace);
	}
	
//	public static void main(String[] args) throws Throwable {
//		System.out.println(encode("yym"));
//	}
}
