package com.nkxgen.spring.jdbc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AccountTypesDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public List<accountTypes> getAllAccounts() {
		String jpql = "SELECT l FROM accountTypes l";
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class);
		return query.getResultList();
	}

	public List<accountTypes> getAllAccountDetails() {
		String jpql = "SELECT l FROM accountTypes l";
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class);
		return query.getResultList();
	}

	public List<accountTypes> getSelectedAccountDetails(int accountType) {
		System.out.println("selected accounts query method  " + accountType);
		String jpql = "SELECT l FROM accountTypes l WHERE accountid = :accountType";
		TypedQuery<accountTypes> query = entityManager.createQuery(jpql, accountTypes.class);
		query.setParameter("accountType", accountType);
		return query.getResultList();
	}
	public void save(accountTypes accountTypes) {
		entityManager.merge(accountTypes);
	}

}
