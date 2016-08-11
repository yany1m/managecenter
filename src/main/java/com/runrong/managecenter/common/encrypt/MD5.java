package com.runrong.managecenter.common.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class MD5 {
	
	/**
     * md5加密
     *
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
       
        //加密后的字符串
        String newstr = Hex.encodeHexString(md5.digest(str.getBytes("utf-8")));
        return newstr;
       
    }
    
    /**
     * md5盐加密
     *
     * @param str
     * @param salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5Salt(String str,String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    	
        return encoderByMd5(encoderByMd5(str)+salt);     
    }
    
// public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		System.out.println(encoderByMd5Salt("123456", "admin123"));
//	}
}
