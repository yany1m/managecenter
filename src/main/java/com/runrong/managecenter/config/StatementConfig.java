package com.runrong.managecenter.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.runrong.managecenter.business.adapter.StatementTemplateAdapter;
import com.runrong.managecenter.common.util.ReadFileUtil;

/**
 * 读取表的配置
 * @author yanyimin
 *
 */
public class StatementConfig {
	
	public static List<Map> balanceStatementList;
	public static List<Map> cashflowStatementList;
	public static List<Map> profitStatementList;
	
	public static LinkedHashMap balanceStatementMap;
	public static LinkedHashMap cashflowStatementMap;
	public static LinkedHashMap profitStatementMap;
		
	public static void init() throws IOException{
		fetchBalanceStatement();
		fetchCashflowStatement();
		fetchProfitStatement();
	}
	
	/**
	 * 读取资产负债表的配置
	 * @throws IOException
	 */
	public static void fetchBalanceStatement() throws IOException{
		
		InputStream in;
		File file =new File("./config/balancestatement.json");
		if(file.exists()){
			in=new FileInputStream(file);
		}else{
			in=StatementConfig.class.getClassLoader().getResourceAsStream("config/balancestatement.json");
		}	
		
		String JsonContext=ReadFileUtil.ReadFile(in);
		//将Json转化为Map
		balanceStatementMap = JSON.parseObject(JsonContext,new TypeReference<LinkedHashMap<String, Map>>() {
        });
		//解析Map
		balanceStatementList= (List<Map>) ((Map) balanceStatementMap.get("body")).get("rows");  			
		in.close();
	}
	
	/**
	 * 读取现金流量表的配置
	 * @throws IOException
	 */
	public static void fetchCashflowStatement() throws IOException{
		
		InputStream in;
		File file =new File("./config/cashflowstatement.json");
		if(file.exists()){
			in=new FileInputStream(file);
		}else{
			in=StatementConfig.class.getClassLoader().getResourceAsStream("config/cashflowstatement.json");
		}	
		
		String JsonContext=ReadFileUtil.ReadFile(in);
		//将Json转化为Map
		cashflowStatementMap = JSON.parseObject(JsonContext,new TypeReference<LinkedHashMap<String, Map>>() {
        });
		//解析Map
		cashflowStatementList= (List<Map>) ((Map) cashflowStatementMap.get("body")).get("rows");  			
		in.close();
	}
	
	/**
	 * 读取利润表的配置
	 * @throws IOException
	 */
	public static void fetchProfitStatement() throws IOException{
		
		InputStream in;
		File file =new File("./config/profitstatement.json");
		if(file.exists()){
			in=new FileInputStream(file);
		}else{
			in=StatementConfig.class.getClassLoader().getResourceAsStream("config/profitstatement.json");
		}	
		
		String JsonContext=ReadFileUtil.ReadFile(in);
		//将Json转化为Map
		profitStatementMap = JSON.parseObject(JsonContext,new TypeReference<LinkedHashMap<String, Map>>() {
        });
		//解析Map
		profitStatementList = (List<Map>) ((Map) profitStatementMap.get("body")).get("rows");  			
		in.close();
	}
}
