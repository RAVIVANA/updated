package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.LoanApplications;
import com.nkxgen.spring.jdbc.model.service;

@Repository
@Transactional
public class LoanApplicationDao implements LoanApplicationDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	service s;

	@Override
	public List<LoanApplication> findByValue(String value) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.loanTypeId = :value and la.status=: val";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("value", value);
		query.setParameter("val", "waiting");

		return query.getResultList();
	}

	@Override
	public void saveLoanApplication(LoanApplication loanApplication) {
		entityManager.persist(loanApplication);
	}

	@Override
	public void updateLoanApplication(LoanApplications loanApplication) {
		String updateQuery = "UPDATE LoanApplication l SET l.amount = :amount, l.emiLimitFrom = :emiLimitFrom, l.emiLimitTo = :emiLimitTo, "
				+ "l.tenureRequested = :tenureRequested, l.nominee = :nominee, l.createdBy = :createdBy, l.createdDate = :createdDate, "
				+ "l.processedBy = :processedBy, l.processDate = :processDate, l.processedStatus = :processedStatus, "
				+ "l.lastUpdatedDate = :lastUpdatedDate, l.lastUpdatedUser = :lastUpdatedUser, l.status = :status, "
				+ "l.remarks = :remarks, l.Attachment = :attachment, l.intrest = :intrest WHERE l.customerId = :customerId";
		entityManager.createQuery(updateQuery).setParameter("amount", loanApplication.getAmount())
				.setParameter("emiLimitFrom", loanApplication.getEmiLimitFrom())
				.setParameter("emiLimitTo", loanApplication.getEmiLimitTo())
				.setParameter("tenureRequested", loanApplication.getTenureRequested())
				.setParameter("intrest", loanApplication.getIntrest())
				.setParameter("nominee", loanApplication.getNominee())
				.setParameter("createdBy", loanApplication.getCreatedBy())
				.setParameter("createdDate", loanApplication.getCreatedDate())
				.setParameter("processedBy", loanApplication.getProcessedBy())
				.setParameter("processDate", loanApplication.getProcessDate())
				.setParameter("processedStatus", loanApplication.getProcessedStatus())
				.setParameter("lastUpdatedDate", loanApplication.getLastUpdatedDate())
				.setParameter("lastUpdatedUser", loanApplication.getLastUpdatedUser())
				.setParameter("status", loanApplication.getStatus())
				.setParameter("remarks", loanApplication.getRemarks())
				.setParameter("attachment", loanApplication.getAttachment())
				.setParameter("customerId", loanApplication.getCustId()).executeUpdate();
	}

	@Override
	public List<LoanApplication> getLoanApplicationsByStatus(String status) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.status = :status";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	public List<LoanAccount> getLoanAccountsByLoanType(String loanType) {
		String queryStr = "SELECT la FROM LoanAccount la WHERE la.loanType = :loanType";
		TypedQuery<LoanAccount> query = entityManager.createQuery(queryStr, LoanAccount.class);
		query.setParameter("loanType", loanType);
		return query.getResultList();
	}

	@Override
	public void delete_Application(int loanId) {
		LoanApplication loanApplication = entityManager.find(LoanApplication.class, loanId);
		if (loanApplication != null) {
			entityManager.remove(loanApplication);
		}

	}

	@Override
	public void approve_Application(int loanId, long custId) {
		LoanApplication loanApplication = entityManager.find(LoanApplication.class, loanId);
		Customertrail customer = entityManager.find(Customertrail.class, custId);
		Customer customer1 = s.dotheservice(customer);
		LoanAccount l = new LoanAccount();
		l.setValuesFromLoanAccount(loanApplication);
		entityManager.persist(customer1);
		entityManager.persist(l);
		entityManager.remove(loanApplication);
		entityManager.remove(customer);
	}
}
