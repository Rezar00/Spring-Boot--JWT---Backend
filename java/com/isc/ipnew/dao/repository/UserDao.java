package com.isc.ipnew.dao.repository;

import com.isc.ipnew.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	boolean existsByUsername(String username);
}
