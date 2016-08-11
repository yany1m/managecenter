package com.runrong.managecenter.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.runrong.managecenter.common.util.ReadFileUtil;

public class ServerPortConfig {
	
	public static int serverPort;
	
	public static void init() throws FileNotFoundException{
		InputStream in;
		File file =new File("./config/serverPort.json");
		if(file.exists()){
			in=new FileInputStream(file);
		}else{
			in=ServerPortConfig.class.getClassLoader().getResourceAsStream("config/serverPort.json");
		}	
		
		String JsonContext=ReadFileUtil.ReadFile(in);
		//将Json转化为Map
		Map<String,Object> jsonMap = null;	
		jsonMap = JSON.parseObject(JsonContext);
		serverPort=(int) jsonMap.get("serverPort");
	}
	
}
