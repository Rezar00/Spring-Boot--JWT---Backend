package com.isc.ipnew.mapper;


import com.isc.ipnew.dao.dto.RoleDTO;
import com.isc.ipnew.dao.entity.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends GenericMapper<UserRole, RoleDTO> {
}
