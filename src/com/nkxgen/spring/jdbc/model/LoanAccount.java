package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loanaccounts")
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "loan_amount")
	private long loanAmount;

	@Column(name = "interest_rate")
	private long interestRate;

	@Column(name = "loan_duration")
	private int loanDuration;

	// Setters
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setInterestRate(long interestRate) {
		this.interestRate = interestRate;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	// Getters
	public Long getLoanId() {
		return loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public long getInterestRate() {
		return interestRate;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setValuesFromLoanAccount(LoanApplication loanAccount) {
		this.loanType = loanAccount.getLoanTypeId();
		this.customerId = loanAccount.getCustId();
		this.loanAmount = loanAccount.getAmount();
		this.interestRate = loanAccount.getIntrest();
		this.loanDuration = loanAccount.getTenureRequested();
	}
}
