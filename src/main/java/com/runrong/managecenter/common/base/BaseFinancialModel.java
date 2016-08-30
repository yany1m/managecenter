package com.runrong.managecenter.common.base;

import java.util.Date;
import java.util.Map;

/**
 * 财务基础bean
 * @author yanyimin
 *
 */
public class BaseFinancialModel {
	
		//年份
		private Date date;
		//内容
		private Map content;
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Map getContent() {
			return content;
		}
		public void setContent(Map content) {
			this.content = content;
		}
}
