package com.aa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.dao.CustomerDAO;
import com.aa.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO dao;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Customer findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		dao.save(customer);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
