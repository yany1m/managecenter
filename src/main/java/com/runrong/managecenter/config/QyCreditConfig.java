package com.runrong.managecenter.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.runrong.managecenter.common.util.ReadFileUtil;

/**
 * 企业评分配置
 * @author yanyimin
 *
 */
public class QyCreditConfig {
	
	public static LinkedHashMap qyCreditConfigMap;
	
	public static void init() throws IOException{
		
		InputStream in;
		File file =new File("./config/qyCreditConfig.json");
		if(file.exists()){
			in=new FileInputStream(file);
		}else{
			in=StatementConfig.class.getClassLoader().getResourceAsStream("config/qyCreditConfig.json");
		}	
		
		String JsonContext=ReadFileUtil.ReadFile(in);
		//将Json转化为Map
		qyCreditConfigMap = JSON.parseObject(JsonContext,new TypeReference<LinkedHashMap<String, Map>>() {
        });
		in.close();
	}

}
