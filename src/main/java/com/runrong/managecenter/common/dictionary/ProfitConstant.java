package com.runrong.managecenter.common.dictionary;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 利润表基本常量
 * @author yanyimin
 *
 */
public class ProfitConstant {
	
	public static final String YYN_YYSR_LR="营业收入";
	public static final String YYN_GYJZBDSY_LR="公允介值变动收益";
	public static final String YYN_TZSY_LR="投资收益";
	public static final String YYN_DLYQYHHYQYDTZSY_LR="对联营企业和合营企业的投资收益";

	public static final String YYN_YYCB_LC="营业成本";
	public static final String YYN_YYSJJFJ_LC="营业税金及附加";
	public static final String YYN_SSFY_LC="销售费用";
	public static final String YYN_GLFY_LC="管理费用";
	public static final String YYN_CWFY_LC="财务费用";
	public static final String YYN_CCJZSS_LC="资产减值损失";

	public static final String YYW_YYWSR_LR="营业外收入";
	public static final String YYW_YYWZC_LC="营业外支出";
	
	public static final String SF_SDSFY_LC="所得税费用";
	
	public static final String MGSY_JBMGSY="基本每股收益";
	public static final String MGSY_XSMGSY="稀释每股收益";

	/**
	 * 通过反射获得属性的值
	 * @param param
	 * @return
	 */
	public static String getName(String param) {
		ProfitConstant ps=new ProfitConstant();
		Class<? extends ProfitConstant> constant=ProfitConstant.class;
		Field[] fields=constant.getDeclaredFields();
		for (Field field : fields) {  
			 String name = field.getName(); 
			 if(name.equals(param)){
				 Object val = null;
				try {
					val = field.get(ps);
				} catch (IllegalArgumentException e) {				
					e.printStackTrace();
				} catch (IllegalAccessException e) {					
					e.printStackTrace();
				}
				 param=val.toString();
			 }
		}
		return param;
	}
	
	public static Map createMap(HttpServletRequest request) {
	
		Map<String,Object> CONTENT=new HashMap<String,Object>();
		
		Map<String,Object> YYW=new HashMap<String,Object>();
		Map<String,Object> YYW_LR=new HashMap<String,Object>();
		Map<String,Object> YYW_LC=new HashMap<String,Object>();
		
		Map<String,Object> YYN=new HashMap<String,Object>();
		Map<String,Object> YYN_LR=new HashMap<String,Object>();
		Map<String,Object> YYN_LC=new HashMap<String,Object>();
		
		Map<String,Object> SF=new HashMap<String,Object>();
		Map<String,Object> SF_LC=new HashMap<String,Object>();
	
		Map<String,Object> MGSY=new HashMap<String,Object>();		
			
	  	ProfitConstant c=new ProfitConstant();
		Class<? extends ProfitConstant> constant=ProfitConstant.class;
		Field[] fields=constant.getDeclaredFields();
		for (Field field : fields) {  
			 String name = field.getName(); 
			 Map<String,Object> map=new HashMap<>();

			 String BN=request.getParameter(name+"_BN")==null?"":request.getParameter(name+"_BN");
			 String SN=request.getParameter(name+"_SN")==null?"":request.getParameter(name+"_SN");
			 
			 map.put("本年累计数", BN);
			 map.put("上年累计数", SN);
			 
//			 System.out.println("name="+"\""+name+"_BN"+"\"");
//			 System.out.println("name="+"\""+name+"_SN"+"\"");
						
			 if(name.startsWith("YYW") && name.endsWith("LR")){					 
				 YYW_LR.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("YYW") && name.endsWith("LC")){					 
				 YYW_LC.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("YYN") && name.endsWith("LR")){					 
				 YYN_LR.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("YYN") && name.endsWith("LC")){					 
				 YYN_LC.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("SF") && name.endsWith("LC")){					 
				 SF_LC.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("MGSY") ){					 
				 MGSY.put(getName(name), map);
				 continue;
			 }			
			 
		}
			
		YYW.put("流入",YYW_LR );
		YYW.put("流出",YYW_LC );
		YYN.put("流入",YYN_LR );
		YYN.put("流出",YYN_LC );
		SF.put("流出",SF_LC );
		
		CONTENT.put("营业外",YYW);
		CONTENT.put("营业内",YYN);
		CONTENT.put("税费",SF);
		CONTENT.put("每股收益",MGSY);
		return CONTENT;
	}

	
	
}
