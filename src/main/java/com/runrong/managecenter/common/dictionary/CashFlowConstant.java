package com.runrong.managecenter.common.dictionary;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 现金流量表基本常量
 * @author yanyimin
 *
 */
public class CashFlowConstant {

	//public static final String JYHDCSDXJLL="经营活动产生的现金流量";
	
	public static final String JYHDCSDXJLL_SSSPTGLWSDDXJ_LR="销售商品、提供劳务收到的现金";
	public static final String JYHDCSDXJLL_SDDSFFH_LR="收到的税费返还";
	public static final String JYHDCSDXJLL_SDQTYJYHDYGDXJ_LR="收到其他与经营活动有关的现金";
	public static final String JYHDCSDXJLL_GMSPJSLWZFDXJ_LC="购买商品、接受劳务支付的现金";
	public static final String JYHDCSDXJLL_ZFGZGYJWZGZFDXJ_LC="支付给职工以及为职工支付的现金";
	public static final String JYHDCSDXJLL_ZFDGXSF_LC="支付的各项税费";
	public static final String JYHDCSDXJLL_ZFQTYJYHDYGDXJ_LC="支付其他与经营活动有关的现金";
	
	//public static final String TZHDCSDXJLL="投资活动产生的现金流量";
	
	public static final String TZHDCSDXJLL_SHTZSDDXJ_LR="收回投资收到的现金";
	public static final String TZHDCSDXJLL_QDTZSYSDDXJ_LR="取得投资收益收到的现金";
	public static final String TZHDCSDXJLL_CZGDZCWXZCHQTCQZCSHDXJJE_LR="处置固定资产、无形资产和其他长期资产收回的现金净额";
	public static final String TZHDCSDXJLL_CZZGSJQTYYDWSDDXJJE_LR="处置子公司及其他营业单位收到的现金净额";
	public static final String TZHDCSDXJLL_SDQTYTZHDYGDXJ_LR="收到其他与投资活动有关的现金";
	public static final String TZHDCSDXJLL_GJGDZCWXZCHQTCQZCZFDXJ_LC="购建固定资产、无形资产和其他长期资产支付的现金";
	public static final String TZHDCSDXJLL_TZZFDXJ_LC="投资支付的现金";
	public static final String TZHDCSDXJLL_QDZGSJQTYYDWZFDXJJE_LC="取得子公司及其他营业单位支付的现金净额";
	public static final String TZHDCSDXJLL_ZFQTYTZHDYGDXJ_LC="支付其他与投资活动有关的现金";
	
	//public static final String CZHDCSDXJLL="筹资活动产生的现金流量";
	
	public static final String CZHDCSDXJLL_XSTZSDDXJ_LR="吸收投资收到的现金";
	public static final String CZHDCSDXJLL_QDJKSDDXJ_LR="取得借款收到的现金";
	public static final String CZHDCSDXJLL_SDQTYCZHDYGDXJ_LR="收到其他与筹资活动有关的现金";
	public static final String CZHDCSDXJLL_CHZWZFDXJ_LC="偿还债务支付的现金";
	public static final String CZHDCSDXJLL_FPGLLRHCHLXZFDXJ_LC="分配股利、利润或偿付利息支付的现金";
	public static final String CZHDCSDXJLL_ZFQTYCZHDYGDXJ_LC="支付其他与筹资活动有关的现金";
	
	//public static final String HLBDDXJJXJDJWDYX="汇率变动对现金及现金等价物的影响";
	
	public static final String HLBDDXJJXJDJWDYX_QCXJJXJDJWYE_LR="加：期初现金及现金等价物余额";
	

	/**
	 * 通过反射获得属性的值
	 * @param param
	 * @return
	 */
	public static String getName(String param) {
		CashFlowConstant c=new CashFlowConstant();
		Class<? extends CashFlowConstant> constant=CashFlowConstant.class;
		Field[] fields=constant.getDeclaredFields();
		for (Field field : fields) {  
			 String name = field.getName(); 
			 if(name.equals(param)){
				 Object val = null;
				try {
					val = field.get(c);
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
		
		Map<String,Object> JYHDCSDXJLL=new HashMap<String,Object>();
		Map<String,Object> JYHDCSDXJLL_LR=new HashMap<String,Object>();
		Map<String,Object> JYHDCSDXJLL_LC=new HashMap<String,Object>();
		
		Map<String,Object> TZHDCSDXJLL=new HashMap<String,Object>();
		Map<String,Object> TZHDCSDXJLL_LR=new HashMap<String,Object>();
		Map<String,Object> TZHDCSDXJLL_LC=new HashMap<String,Object>();
		
		Map<String,Object> CZHDCSDXJLL=new HashMap<String,Object>();
		Map<String,Object> CZHDCSDXJLL_LR=new HashMap<String,Object>();
		Map<String,Object> CZHDCSDXJLL_LC=new HashMap<String,Object>();
	
		Map<String,Object> HLBDDXJJXJDJWDYX=new HashMap<String,Object>();
		Map<String,Object> HLBDDXJJXJDJWDYX_LR=new HashMap<String,Object>();
		Map<String,Object> HLBDDXJJXJDJWDYX_LC=new HashMap<String,Object>();
			
	  	CashFlowConstant c=new CashFlowConstant();
		Class<? extends CashFlowConstant> constant=CashFlowConstant.class;
		Field[] fields=constant.getDeclaredFields();
		for (Field field : fields) {  
			 String name = field.getName(); 
			 Map<String,Object> map=new HashMap<>();
			 
			 Object BN=(request.getParameter(name+"_BN")==null || request.getParameter(name+"_BN").equals(""))?"":Double.valueOf(request.getParameter(name+"_BN"));
			 Object SN=(request.getParameter(name+"_SN")==null || request.getParameter(name+"_SN").equals(""))?"":Double.valueOf(request.getParameter(name+"_SN"));
		 
			 map.put("本年累计金额", BN);
			 map.put("上年累计金额", SN);
			 
//			 System.out.println("name="+"\""+name+"_BN"+"\"");
//			 System.out.println("name="+"\""+name+"_SN"+"\"");
						
			 if(name.startsWith("JYHDCSDXJLL") && name.endsWith("LR")){					 
				 JYHDCSDXJLL_LR.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("JYHDCSDXJLL") && name.endsWith("LC")){					 
				 JYHDCSDXJLL_LC.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("TZHDCSDXJLL") && name.endsWith("LR")){					 
				 TZHDCSDXJLL_LR.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("TZHDCSDXJLL") && name.endsWith("LC")){					 
				 TZHDCSDXJLL_LC.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("CZHDCSDXJLL") && name.endsWith("LR")){					 
				 CZHDCSDXJLL_LR.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("CZHDCSDXJLL") && name.endsWith("LC")){					 
				 CZHDCSDXJLL_LC.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("HLBDDXJJXJDJWDYX") && name.endsWith("LR")){					 
				 HLBDDXJJXJDJWDYX_LR.put(getName(name), map);
				 continue;
			 }
			 if(name.startsWith("HLBDDXJJXJDJWDYX") && name.endsWith("LC")){					 
				 HLBDDXJJXJDJWDYX_LC.put(getName(name), map);
				 continue;
			 }
			 
		}
			
		JYHDCSDXJLL.put("流入",JYHDCSDXJLL_LR );
		JYHDCSDXJLL.put("流出",JYHDCSDXJLL_LC );
		TZHDCSDXJLL.put("流入",TZHDCSDXJLL_LR );
		TZHDCSDXJLL.put("流出",TZHDCSDXJLL_LC );
		CZHDCSDXJLL.put("流入",CZHDCSDXJLL_LR );
		CZHDCSDXJLL.put("流出",CZHDCSDXJLL_LC );
		HLBDDXJJXJDJWDYX.put("流入",HLBDDXJJXJDJWDYX_LR );
		HLBDDXJJXJDJWDYX.put("流出",HLBDDXJJXJDJWDYX_LC );
		
		CONTENT.put("经营活动产生的现金流量",JYHDCSDXJLL);
		CONTENT.put("投资活动产生的现金流量",TZHDCSDXJLL);
		CONTENT.put("筹资活动产生的现金流量",CZHDCSDXJLL);
		CONTENT.put("汇率变动对现金及现金等价物的影响",HLBDDXJJXJDJWDYX);
		return CONTENT;
	}
	
}
