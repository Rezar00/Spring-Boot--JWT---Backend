package com.isc.ipnew.service;

import com.isc.ipnew.dao.dto.UserDTO;
import com.isc.ipnew.dao.entity.User;
import com.isc.ipnew.dao.repository.UserDao;
import com.isc.ipnew.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;

    public UserService(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.entitiesToModel((List<User>) userDao.findAll());
    }

    public UserDTO getUserByUsername(String username) {
        return userMapper.entityToModel(userDao.findByUsername(username));
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    public boolean isUserExistById(Long id) {
        return userDao.existsById(id);
    }

    public boolean isUserExistByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    public UserDTO addUser(UserDTO dto) {
        User savedUser = userDao.save(userMapper.modelToEntity(dto));
        return userMapper.entityToModel(savedUser);
    }

    public UserDTO updateUser(UserDTO dto) {
        User savedUser = userDao.save(userMapper.modelToEntity(dto));
        return userMapper.entityToModel(savedUser);
    }
}
