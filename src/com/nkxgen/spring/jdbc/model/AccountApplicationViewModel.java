package com.nkxgen.spring.jdbc.model;
public class AccountApplicationViewModel {

	private Long acapId;
	private Long customerId;
	private String acapNomineeFirstName;
	private String acapNomineeLastName;
	private String acap_acty_id;
	private String createdBy;
	private String applicationDate;
	private String createdDate;
	private String processedBy;
	private String aadhar;
	private String pan;
	private String passport;
	private String driving;
	private String jobcard;

	public Long getAcapId() {
		return acapId;
	}

	public void setAcapId(Long acapId) {
		this.acapId = acapId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAcapNomineeFirstName() {
		return acapNomineeFirstName;
	}

	public void setAcapNomineeFirstName(String acapNomineeFirstName) {
		this.acapNomineeFirstName = acapNomineeFirstName;
	}

	public String getAcapNomineeLastName() {
		return acapNomineeLastName;
	}

	public void setAcapNomineeLastName(String acapNomineeLastName) {
		this.acapNomineeLastName = acapNomineeLastName;
	}

	public String getAcap_acty_id() {
		return acap_acty_id;
	}

	public void setAcap_acty_id(String acap_acty_id) {
		this.acap_acty_id = acap_acty_id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(String processedBy) {
		this.processedBy = processedBy;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getDriving() {
		return driving;
	}

	public void setDriving(String driving) {
		this.driving = driving;
	}

	public String getJobcard() {
		return jobcard;
	}

	public void setJobcard(String jobcard) {
		this.jobcard = jobcard;
	}

	public void setEntityModelValues(AccountApplication entity) {
		this.acapId = entity.getAcapId();
		this.customerId = entity.getCustomerId();
		this.acapNomineeFirstName = entity.getAcapNomineeFirstName();
		this.acapNomineeLastName = entity.getAcapNomineeLastName();
		this.acap_acty_id = entity.getAcap_acty_id();
		this.createdBy = entity.getCreatedBy();
		this.applicationDate = entity.getApplicationDate();
		this.createdDate = entity.getCreatedDate();
		this.processedBy = entity.getProcessedBy();
		this.aadhar = entity.getAadhar();
		this.pan = entity.getPan();
		this.passport = entity.getPassport();
		this.driving = entity.getDriving();
		this.jobcard = entity.getJobcard();
	}
}
