package com.springmycontact.repository;

import org.springframework.data.repository.CrudRepository;

import com.springmycontact.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);

}
