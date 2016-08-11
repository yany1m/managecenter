package com.runrong.managecenter.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 读文件
 * @author yanyimin
 *
 */
public class ReadFileUtil {
	
	public static String ReadFile(InputStream in){
		BufferedReader reader = null;
		String laststr = "";
		try{			
			reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
			String tempString = null;
			while((tempString = reader.readLine()) != null){
				laststr += tempString;
			}
			reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return laststr;
	}

}

