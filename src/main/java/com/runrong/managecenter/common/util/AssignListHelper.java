package com.runrong.managecenter.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runrong.managecenter.business.model.datacollection.BalanceStatement;
import com.runrong.managecenter.business.model.datacollection.CashFlowStatement;
import com.runrong.managecenter.business.model.datacollection.EnterpriseFinancialData;
import com.runrong.managecenter.business.model.datacollection.ProfitStatement;
import com.runrong.managecenter.config.StatementConfig;

/**
 * 将EnterpriseFinancialData中的值赋值到前端模板中
 * @author yanyimin
 *
 */
public class AssignListHelper {
	private static Logger logger = LoggerFactory.getLogger(AssignListHelper.class);
	
	public static List assignBalanceStatementList(EnterpriseFinancialData efd){		

		List<Map> list = null;
		try {
			list = deepCopy(StatementConfig.balanceStatementList);
			for(Map map:list){
				List<String> data=(List) map.get("data");
				data.set(1,getBalanceStatementData(efd,data.get(1)));
				data.set(2,getBalanceStatementData(efd,data.get(2)));
				data.set(7,getBalanceStatementData(efd,data.get(7)));
				data.set(8,getBalanceStatementData(efd,data.get(8)));
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public static List assignCashflowStatementList(EnterpriseFinancialData efd){				
		List<Map> list = null;
		try {
			list = deepCopy(StatementConfig.cashflowStatementList);
			for(Map map:list){
				List<String> data=(List) map.get("data");
				data.set(1,getCashflowStatementData(efd,data.get(1)));
				data.set(2,getCashflowStatementData(efd,data.get(2)));
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public static List assignProfitStatementList(EnterpriseFinancialData efd){				
		List<Map> list = null;
		try {
			list = deepCopy(StatementConfig.profitStatementList);
			for(Map map:list){
				List<String> data=(List) map.get("data");
				data.set(1,getProfitStatementData(efd,data.get(1)));
				data.set(2,getProfitStatementData(efd,data.get(2)));
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	/**
	 * list深拷贝
	 * @param src
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List deepCopy(List src) throws IOException, ClassNotFoundException{   
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();   
        ObjectOutputStream out = new ObjectOutputStream(byteOut);   
        out.writeObject(src);   
       
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
        ObjectInputStream in =new ObjectInputStream(byteIn);   
        List dest = (List)in.readObject();   
        return dest;
	}
	
	public static String getBalanceStatementData(EnterpriseFinancialData efd,String content){
		if(content==null || content.equals("")){
			return "";
		}
		String[] s=content.split("\\.");
		Object o = null;
		String data=null;
		BalanceStatement bs=efd.getBalanceStatements().get(0);
		try{
		
			for(String key:s){
				if(o==null){
					o=bs.getContent().get(key);
				}else{
					o=((Map) o).get(key);
				}				
			}	
			//new BigDecimal用来解决double.toString后数字过大自动用科学计数法表达
			data= new BigDecimal(o.toString()).toPlainString();
		//如果拿到的值为"",则会出现此异常
		//用捕获异常来代替了if判断	
		}catch(NumberFormatException e){
			return "";
		}catch(NullPointerException e){
			logger.error("资产负债表模板与数据不一致，模板为:"+content+",企业注册号为:"+efd.getEnterpriseRegistrationNumber()+",date:"+bs.getDate());
			return "";
		}
		return data;
	}
	
	public static String getCashflowStatementData(EnterpriseFinancialData efd,String content){
		if(content==null || content.equals("")){
			return "";
		}
		String[] s=content.split("\\.");
		Object o = null;
		String data=null;
		CashFlowStatement cs=efd.getCashFlowStatements().get(0);		
		try{
			for(String key:s){
				if(o==null){
					o=cs.getContent().get(key);
				}else{
					o=((Map) o).get(key);
				}				
			}			
			data= new BigDecimal(o.toString()).toPlainString();
		//用捕获异常来代替了if判断	
		}catch(NumberFormatException e){
			return "";
		}catch(NullPointerException e){
			logger.error("现金流量表模板与数据不一致，模板为:"+content+",企业注册号为:"+efd.getEnterpriseRegistrationNumber()+",date:"+cs.getDate());
			return "";
		}
		return data;
	}
	
	public static String getProfitStatementData(EnterpriseFinancialData efd,String content){
		if(content==null || content.equals("")){
			return "";
		}
		String[] s=content.split("\\.");
		Object o = null;
		String data=null;
		ProfitStatement ps=efd.getProfitStatements().get(0);		
		try{
			for(String key:s){
				if(o==null){
					o=ps.getContent().get(key);
				}else{
					o=((Map) o).get(key);
				}				
			}			
			data= new BigDecimal(o.toString()).toPlainString();
			//用捕获异常来代替了if判断	
		}catch(NumberFormatException e){
			return "";
		}catch(NullPointerException e){
			logger.error("利润表模板与数据不一致，模板为:"+content+",企业注册号为:"+efd.getEnterpriseRegistrationNumber()+",date:"+ps.getDate());
			return "";
		}
		return data;
	}
}
