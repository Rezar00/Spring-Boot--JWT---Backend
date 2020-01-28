package com.isc.ipnew.dao.repository;

import com.isc.ipnew.dao.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleDao extends CrudRepository<UserRole, Long> {

    Set<UserRole> findByUserId(Long userId);
}
