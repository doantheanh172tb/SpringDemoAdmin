package com.doantheanh.springmycontact.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.doantheanh.springmycontact.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	List<Contact> findByNameContaining(String q);

}
