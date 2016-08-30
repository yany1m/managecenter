package com.runrong.managecenter.common.dictionary;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



/**
 * 资产负债表基本常量
 * @author yanyimin
 *
 */
public class BalanceConstant {
			
	public static final String LDZC_HBZJ = "货币资金";
	public static final String LDZC_JXYJR = "交易性金融";
	public static final String LDZC_YSPJ = "应收票据";
	public static final String LDZC_YSZK = "应收账款";
	public static final String LDZC_YFKX = "预付款项";
	public static final String LDZC_YSLX = "应收利息";
	public static final String LDZC_YSGL = "应收股利";
	public static final String LDZC_QTYSK = "其他应收款";
	public static final String LDZC_CH = "存货";
	public static final String LDZC_YNNDQDFLDZC = "一年内到期的非流动资产";
	public static final String LDZC_QTLDZC = "其他流动资产";
	
	
	public static final String FLDZC_KGCSJRZC = "可供出售金融资产";
	public static final String FLDZC_CYZDQTZ = "持有至到期投资";
	public static final String FLDZC_CQYSK = "长期应收款";
	public static final String FLDZC_CQGQTZ = "长期股权投资";
	public static final String FLDZC_ZCXFDC = "资产性房地产";
	public static final String FLDZC_GDZC = "固定资产";
	public static final String FLDZC_ZJGC = "在建工程";
	public static final String FLDZC_GCWZ = "工程物资";
	public static final String FLDZC_GDZCQL = "固定资产清理";
	public static final String FLDZC_SCXSWZC = "生产性生物资产";
	public static final String FLDZC_YQZC = "油气资产";
	public static final String FLDZC_WXZC = "无形资产";
	public static final String FLDZC_KFZC = "开发支出";
	public static final String FLDZC_SY = "商誉";
	public static final String FLDZC_CQCTFY = "长期待摊费用";
	public static final String FLDZC_DYSDSZC = "递延所得税资产";
	public static final String FLDZC_QTFLDZC = "其他非流动资产";
	
	
	public static final String LDFZ_DQJK = "短期借款";
	public static final String LDFZ_JYXJRFZ = "交易性金融负债";
	public static final String LDFZ_JFPJ = "应付票据";
	public static final String LDFZ_JFZK = "应付账款";
	public static final String LDFZ_YSZK = "预收账款";
	public static final String LDFZ_YFZGXC = "应付职工薪酬";
	public static final String LDFZ_YJSF = "应交税费";
	public static final String LDFZ_YFLX = "应付利息";
	public static final String LDFZ_YFGL = "应付股利";
	public static final String LDFZ_QTYFK = "其他应付款";
	public static final String LDFZ_YNNDQDFLDFZ = "一年内到期的非流动负债";
	public static final String LDFZ_QTLDFZ = "其他流动负债";
	
	
	public static final String FLDFZ_CQJK = "长期借款";
	public static final String FLDFZ_YFZJ = "应付债券";
	public static final String FLDFZ_CQYFK = "长期应付款";
	public static final String FLDFZ_ZXYFK= "专项应付款";
	public static final String FLDFZ_YJFZ= "预计负债";
	public static final String FLDFZ_DYSDSFZ= "递延所得税负债";
	public static final String FLDFZ_QTFLDFZ= "其他非流动负债";
	
	
	public static final String SYZQY_SSZB= "实收资本或股本";
	public static final String SYZQY_ZBGJ= "资本公积";
	public static final String SYZQY_KCG= "库存股";
	public static final String SYZQY_ZXCB= "专项储备";
	public static final String SYZQY_YYGJ= "盈余公积";
	public static final String SYZQY_WFPLR= "未分配利润";
	public static final String SYZQY_SSGDQY= "少数股东权益";
	
	/**
	 * 通过反射获得属性的值
	 * @param param
	 * @return
	 */
	public static String getName(String param) {
		BalanceConstant c=new BalanceConstant();
		Class<? extends BalanceConstant> constant=BalanceConstant.class;
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
		
		Map<String,Object> ZC=new HashMap<String,Object>();
		
		Map<String,Object> LDZC=new HashMap<String,Object>();
		
		Map<String,Object> FLDZC=new HashMap<String,Object>();
	
		Map<String,Object> FZJSYZQY=new HashMap<String,Object>();
		
		Map<String,Object> LDFZ=new HashMap<String,Object>();
		
	  	Map<String,Object> FLDFZ=new HashMap<String,Object>();
		
	  	Map<String,Object> SYZQY=new HashMap<String,Object>();
		
	  	BalanceConstant c=new BalanceConstant();
		Class<? extends BalanceConstant> constant=BalanceConstant.class;
		Field[] fields=constant.getDeclaredFields();
		for (Field field : fields) {  
			 String name = field.getName(); 
			 Map<String,Object> map=new HashMap<>();

			 Object qm=(request.getParameter(name+"_QM")==null || request.getParameter(name+"_QM").equals(""))?"":Double.valueOf(request.getParameter(name+"_QM"));
			 Object nc=(request.getParameter(name+"_NC")==null || request.getParameter(name+"_NC").equals(""))?"":Double.valueOf(request.getParameter(name+"_NC"));
			 
//			 System.out.println("name="+"\""+name+"_QM"+"\"");
//			 System.out.println("name="+"\""+name+"_NC"+"\"");
			 
			 map.put("期末余额", qm);
			 map.put("年初余额", nc);
			
			 String[] part=name.split("_");
			 if(part[0].equals("LDZC")){					 
				 LDZC.put(getName(name), map);
			 }else if(part[0].equals("FLDZC")){				 
				 FLDZC.put(getName(name), map);
			 }else if(part[0].equals("LDFZ")){				 
				 LDFZ.put(getName(name), map);
			 }else if(part[0].equals("FLDFZ")){			
				 FLDFZ.put(getName(name), map);
			 }else if(part[0].equals("SYZQY")){				
				 SYZQY.put(getName(name), map);
			 }
		}
			
		ZC.put("流动资产",LDZC );
		ZC.put("非流动资产",FLDZC );
		FZJSYZQY.put("流动负债",LDFZ );
		FZJSYZQY.put("非流动负债",FLDFZ );
		FZJSYZQY.put("所有者权益或股东权益",SYZQY );
		
		CONTENT.put("资产",ZC);
		CONTENT.put("负债及所有者权益",FZJSYZQY);
		return CONTENT;
	}
}
