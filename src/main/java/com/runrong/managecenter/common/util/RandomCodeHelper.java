package com.runrong.managecenter.common.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RandomCodeHelper {

   
    /**
     * 随机生成一串指定长度的数字字母混合的字符串
     */
    public static String randomNumCode(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
        	int j=ThreadLocalRandom.current().nextInt(0,3);
        	if(j==0){
        		builder.append( ThreadLocalRandom.current().nextInt(0,10));
        	}else if(j==1){
        		 builder.append((char)ThreadLocalRandom.current().nextInt(65,90));
        	}else { 
                builder.append((char)ThreadLocalRandom.current().nextInt(97,122));
        	}  
        }
        String code = builder.toString();
        return code;
    }
    
    
    /*public static void main(String[] args) {
		RandomCodeHelper r=new RandomCodeHelper();
		String t=r.randomNumCode(5);
		System.out.println(t);
	}*/
    public static HttpSession setVerifyCodeInSession(HttpServletRequest request){
    	
    	HttpSession session=request.getSession();
    	//设置验证码
    	session.setAttribute("verifyCode", RandomCodeHelper.randomNumCode(5));    	
    	Date date =new Date();
    	//验证码创建时间
    	session.setAttribute("verifyCodeCreateTime", new Timestamp(date.getTime()));
    	return session;
    }
}
