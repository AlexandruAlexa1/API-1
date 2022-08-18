package com.aa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Customer> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		return query.getResultList();
	}

	@Override
	public Customer findById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Customer.class, id);
	}

	@Override
	public void save(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteById(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<?> query = session.createQuery("delete from Customer where id=:employeeId");
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
