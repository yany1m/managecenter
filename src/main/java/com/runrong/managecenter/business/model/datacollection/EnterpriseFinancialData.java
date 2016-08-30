package com.runrong.managecenter.business.model.datacollection;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 企业财务数据
 * @author yanyimin
 *
 */
@Document(collection="enterpriseFinancialData")
public class EnterpriseFinancialData {
	
	@Id
	//mongodb自建id
	private String uuid;
	//企业注册号
	private String enterpriseRegistrationNumber;
	//资产负债表
	private List<BalanceStatement> balanceStatements;
	//利润表
	private List<ProfitStatement> profitStatements;
	//现金流量表
	private List<CashFlowStatement> cashFlowStatements;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getEnterpriseRegistrationNumber() {
		return enterpriseRegistrationNumber;
	}
	public void setEnterpriseRegistrationNumber(
			String enterpriseRegistrationNumber) {
		this.enterpriseRegistrationNumber = enterpriseRegistrationNumber;
	}
	public List<BalanceStatement> getBalanceStatements() {
		return balanceStatements;
	}
	public void setBalanceStatements(List<BalanceStatement> balanceStatements) {
		this.balanceStatements = balanceStatements;
	}
	public List<ProfitStatement> getProfitStatements() {
		return profitStatements;
	}
	public void setProfitStatements(List<ProfitStatement> profitStatements) {
		this.profitStatements = profitStatements;
	}
	public List<CashFlowStatement> getCashFlowStatements() {
		return cashFlowStatements;
	}
	public void setCashFlowStatements(List<CashFlowStatement> cashFlowStatements) {
		this.cashFlowStatements = cashFlowStatements;
	}
	
	
	
}
