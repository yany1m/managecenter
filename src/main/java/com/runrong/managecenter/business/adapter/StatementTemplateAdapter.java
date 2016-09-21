package com.runrong.managecenter.business.adapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 报表模板适配器
 * @author yanyimin
 *
 */
@Component
public class StatementTemplateAdapter {
	private static final String[] INDEX={"一、","二、","三、","四、","五、","六、","七、","八、","九、","十、"};
	
	/**
	 * 转化为风控系统的资产负债表的模板
	 * @param test
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map transformBalanceStatementTemplate(String template){
		//String template = (String) bs.getContent().get("body");
		LinkedHashMap<String, Map>  map= JSON.parseObject(template,new TypeReference<LinkedHashMap<String, Map>>() {
        });
		
		List headList =(List) ((Map) map.get("head")).get("names"); 	
		List<Map> bodyList =(List<Map>) ((Map) map.get("body")).get("rows"); 
				
		headList.remove(3);
		headList.remove(3);
		headList.remove(6);
		headList.remove(6);
		
		bodyList.get(0).put("theme", "title");
		for(Map dataMap : bodyList){
			//给title类型的标题加上：
			List dataList=(List) dataMap.get("data");	
			if(dataList.get(5).equals("title")){				
				dataList.set(0,dataList.get(0)+"：");
			}
			if(dataList.get(11).equals("title")){
				dataList.set(6,dataList.get(6)+"：");
			}
			
			//给item类型的内容加上${}
			if(dataList.get(5).equals("item")){			
				dataList.set(1,"${"+dataList.get(1)+"}");
				dataList.set(2,"${"+dataList.get(2)+"}");
			}		
			if(dataList.get(11).equals("item")){
				
				dataList.set(7,"${"+dataList.get(7)+"}");
				dataList.set(8,"${"+dataList.get(8)+"}");
			}
			
		}
		
		//重新组装count
		for(Map dataMap : bodyList){
			List dataList=(List) dataMap.get("data");
			if(dataList.get(5).equals("count")){
				List list=createCount(dataList, bodyList, 1);
				dataList.set(1,list.get(0));
				dataList.set(2,list.get(1));
			}
			if(dataList.get(11).equals("count")){
				List list=createCount(dataList, bodyList, 7);
				dataList.set(7,list.get(0));
				dataList.set(8,list.get(1));
			}				
		}
		
		//去掉多余的元素
		for(Map dataMap : bodyList){
			List dataList=(List) dataMap.get("data");
			
			dataList.remove(3);
			dataList.remove(3);
			dataList.remove(3);
			dataList.remove(6);
			dataList.remove(6);
			dataList.remove(6);
		}
			
		return map;
	}
	
	
	/**
	 * 转化为风控系统的现金流量表的模板
	 * @param test
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map transformCashflowStatementTemplate(String template){
		//String template = (String) bs.getContent().get("body");
		LinkedHashMap<String, Map>  map= JSON.parseObject(template,new TypeReference<LinkedHashMap<String, Map>>() {
		});
		
		List headList =(List) ((Map) map.get("head")).get("names"); 	
		List<Map> bodyList =(List<Map>) ((Map) map.get("body")).get("rows"); 
		List<Map> removeList=new ArrayList<Map>();
				
		headList.remove(3);
		headList.remove(3);
		
		for(Map dataMap : bodyList){
			//给title类型的标题加上：,加上"theme","title"
			List dataList=(List) dataMap.get("data");	
			if(dataList.get(5).toString().startsWith("title")){
				dataMap.put("theme", "title");
				dataList.set(0,dataList.get(0)+"：");
			}
			
			//给item类型的内容加上${}
			if(dataList.get(5).toString().endsWith("item")){			
				dataList.set(1,"${"+dataList.get(1)+"}");
				dataList.set(2,"${"+dataList.get(2)+"}");
			}		
			
		}
		
		//重新组装count
		for(Map dataMap : bodyList){
			List dataList=(List) dataMap.get("data");
			if(dataList.get(5).toString().endsWith("count")){
				List list=createCount(dataList, bodyList);
				dataList.set(1,list.get(0));
				dataList.set(2,list.get(1));
			}					
		}
		
		//去掉多余的元素
		for(Map dataMap : bodyList){
			List dataList=(List) dataMap.get("data");
			
			//可能会remove错误的值！！！！！！
			if(dataList.get(0).equals("流入：") || dataList.get(0).equals("流出：")){
				removeList.add(dataMap);
			}
			dataList.remove(3);
			dataList.remove(3);
			dataList.remove(3);
		}
		
		bodyList.removeAll(removeList);
				
		return map;
	}
	
	/**
	 * 转化为风控系统的利润表的模板
	 * @param test
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map transformProfitStatementTemplate(String template){
		//String template = (String) bs.getContent().get("body");
		LinkedHashMap<String, Map>  map= JSON.parseObject(template,new TypeReference<LinkedHashMap<String, Map>>() {
		});
		
		List headList =(List) ((Map) map.get("head")).get("names"); 	
		List<Map> bodyList =(List<Map>) ((Map) map.get("body")).get("rows"); 
		List<Map> removeList=new ArrayList<Map>();
		
		headList.remove(3);
		headList.remove(3);
		
		for(Map dataMap : bodyList){
			//给title类型的标题加上：,加上"theme","title"
			List dataList=(List) dataMap.get("data");	
			if(dataList.get(5).toString().startsWith("title")){
				dataMap.put("theme", "title");
				//dataList.set(0,dataList.get(0)+":");
			}
			
			//给item类型的内容加上${}
			if(dataList.get(5).toString().endsWith("item")){			
				dataList.set(1,"${"+dataList.get(1)+"}");
				dataList.set(2,"${"+dataList.get(2)+"}");
			}		
			
		}
		
		//重新组装count
		for(Map dataMap : bodyList){
			List dataList=(List) dataMap.get("data");
			if(dataList.get(5).toString().endsWith("count")){
				List list=createCount(dataList, bodyList);
				dataList.set(1,list.get(0));
				dataList.set(2,list.get(1));
			}					
		}
		
		//去掉多余的元素
		for(int i=0;i<bodyList.size();i++){
			List dataList=(List) bodyList.get(i).get("data");
			List childlist = new ArrayList();
			
			//可能会remove错误的值！！！！！！
			if(dataList.get(0).equals("减")){
				childlist=(List) bodyList.get(i+1).get("data");
				childlist.set(0,"减："+childlist.get(0));
				removeList.add(bodyList.get(i));
			}else if(dataList.get(0).equals("加")){
				childlist=(List) bodyList.get(i+1).get("data");
				childlist.set(0,"加："+childlist.get(0));
				removeList.add(bodyList.get(i));
			}
			dataList.remove(3);
			dataList.remove(3);
			dataList.remove(3);
		}
		
		bodyList.removeAll(removeList);
		
		int index=0;
		
		for(Map dataMap : bodyList){
			if(dataMap.get("theme")!=null){
			//给title类型的标题加上"一、"
			List dataList=(List) dataMap.get("data");	
			
			//dataMap.put("theme", "title");
			dataList.set(0,INDEX[index]+dataList.get(0));
			index++;
			}			
		}	
		
		return map;
	}
	
	@SuppressWarnings("rawtypes")
	public List<String> createCount(List dataList,List<Map> bodyList,int i){
		List<String> contents = new ArrayList<String>();
		String content="";
		String content1="";
		//查找子id
		if(dataList.get(i)!=null && !dataList.get(i).equals("")){
			String[] id=dataList.get(i).toString().split(",");
			for(String s:id){
				for(Map dataMap : bodyList){
					List list=(List) dataMap.get("data");
					if(list.get(i+2).equals(s)){						
						content+="+"+list.get(i);
						content1+="+"+list.get(i+1);
						
					}					
				}
			}
		}
		//查找父id
		if(dataList.get(i+1)!=null && !dataList.get(i+1).equals("")){
			String[] id=dataList.get(i+1).toString().split(",");
			for(String s:id){
				for(Map dataMap : bodyList){
					List list=(List) dataMap.get("data");
					if(list.get(i+3).equals(s)){
						content+="+"+list.get(i);
						content1+="+"+list.get(i+1);
					}					
				}
			}
		}
		contents.add(content.substring(1, content.length()));
		contents.add(content1.substring(1, content1.length()));
		
		return contents;
	}
	
	@SuppressWarnings("rawtypes")
	public List<String> createCount(List dataList,List<Map> bodyList){
		List<String> contents = new ArrayList<String>();
		String content="";
		String content1="";
		//查找子id
		if(dataList.get(1)!=null && !dataList.get(1).equals("")){
			String[] id=dataList.get(1).toString().split(",");
			for(String s:id){
				for(Map dataMap : bodyList){
					List list=(List) dataMap.get("data");
					if(list.get(3).equals(s)){						
						content+="+"+list.get(1);	
						content1+="+"+list.get(2);
					}else if(("-"+list.get(3)).equals(s)){
						content+="-"+"("+list.get(1)+")";	
						content1+="-"+"("+list.get(2)+")";
					}					
				}
			}		
		}
		//查找父id
		if(dataList.get(2)!=null && !dataList.get(2).equals("")){
			String[] id=dataList.get(2).toString().split(",");
			String negativeContent="";
			String negativeContent1="";
			
			for(String s:id){
				for(Map dataMap : bodyList){
					List list=(List) dataMap.get("data");									
					if(list.get(4).equals(s)){
						content+="+"+list.get(1);
						content1+="+"+list.get(2);
					}else if(("-"+list.get(4)).equals(s)){
						negativeContent+="+"+list.get(1);	
						negativeContent1+="+"+list.get(2);
					}				
				}
			}
			if(!negativeContent.equals("")){
				negativeContent=negativeContent.substring(1, negativeContent.length());
				negativeContent1=negativeContent1.substring(1, negativeContent1.length());
				
				content+="-"+"("+negativeContent+")";	
				content1+="-"+"("+negativeContent1+")";
			}
	
		}
		
		contents.add(content.substring(1, content.length()));
		contents.add(content1.substring(1, content1.length()));
		
		return contents;
	}
}
