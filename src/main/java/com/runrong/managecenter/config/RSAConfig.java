package com.runrong.managecenter.config;

import java.security.interfaces.RSAPublicKey;

import org.apache.commons.codec.binary.Hex;

import com.runrong.managecenter.common.encrypt.RSAUtils;

/**
 * RSA配置
 * @author yanyimin
 *
 */
public class RSAConfig {
	
	public static String modulus=null;
	
	public static String exponent=null;
	
	public static void init(){
		RSAPublicKey publicKey = RSAUtils.getDefaultPublicKey();
		modulus=String.valueOf(Hex.encodeHex(publicKey.getModulus().toByteArray()));
		exponent=String.valueOf(Hex.encodeHex(publicKey.getPublicExponent().toByteArray()));
		
	}
}
