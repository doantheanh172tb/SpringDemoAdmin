package com.doantheanh.springmycontact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doantheanh.springmycontact.domain.Contact;
import com.doantheanh.springmycontact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Iterable<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> search(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
