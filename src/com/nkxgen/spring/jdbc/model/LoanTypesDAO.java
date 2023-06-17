package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoanTypesDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<LoansTypes> getAllLoans() {
		String jpql = "SELECT l FROM LoansTypes l";
		TypedQuery<LoansTypes> query = entityManager.createQuery(jpql, LoansTypes.class);
		return query.getResultList();
	}

	public List<LoansTypes> getAllLoanDetails() {
		String jpql = "SELECT l FROM LoansTypes l";
		TypedQuery<LoansTypes> query = entityManager.createQuery(jpql, LoansTypes.class);
		return query.getResultList();
	}

	public List<LoansTypes> getSelectedLoanDetails(int loanType) {
		System.out.println("selected loans query method  " + loanType);
		String jpql = "SELECT l FROM LoansTypes l WHERE loanid = :loanType";
		TypedQuery<LoansTypes> query = entityManager.createQuery(jpql, LoansTypes.class);
		query.setParameter("loanType", loanType);
		return query.getResultList();
	}
	
	public void save(LoansTypes LoansTypes) {
		entityManager.merge(LoansTypes);
	}

}
