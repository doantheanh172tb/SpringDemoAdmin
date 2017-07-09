package com.springmycontact.repository;

import org.springframework.data.repository.CrudRepository;

import com.springmycontact.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);

}
