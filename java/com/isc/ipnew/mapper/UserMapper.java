package com.isc.ipnew.mapper;


import com.isc.ipnew.dao.dto.UserDTO;
import com.isc.ipnew.dao.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper extends GenericMapper<User, UserDTO> {
}
