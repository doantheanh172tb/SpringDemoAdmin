package com.springmycontact.service;

import java.util.List;

import com.springmycontact.domain.Contact;

public interface ContactService {

	Iterable<Contact> findAll();

	List<Contact> search(String q);

	Contact findOne(int id);

	void save(Contact contact);

	void delete(int id);

}
