package com.isc.ipnew.controller;

import com.isc.ipnew.dao.dto.UserDTO;
import com.isc.ipnew.exception.CustomException;
import com.isc.ipnew.model.UserListResponse;
import com.isc.ipnew.model.UserResponse;
import com.isc.ipnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController()
public class UserController {

    private final UserService userService;

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<UserListResponse> getAllUsers() {
        List<UserDTO> listOfAllUsers = userService.getAllUsers();
        UserListResponse listResponse = new UserListResponse(listOfAllUsers);
        return ResponseEntity.ok(listResponse);
    }


    @GetMapping(value = "/get/user/{username}", produces = "application/json")
    public ResponseEntity<UserResponse> getUser(@PathVariable(name = "username") String username) {
        if (!userService.isUserExistByUsername(username)) {
            String message = messageSource.getMessage("user.not.found",
                    new Object[]{username}, new Locale("fa", "IR"));
            throw new CustomException(message, HttpStatus.NOT_FOUND);
        }
        UserDTO user = userService.getUserByUsername(username);
        UserResponse userResponse = new UserResponse(user);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping(value = "/delete/user/{id}", produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable(name = "id") Long id) {
        if (!userService.isUserExistById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserDTO dto) {
        UserDTO userDTO = userService.addUser(dto);
        UserResponse userResponse = new UserResponse(userDTO);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserDTO dto) {
        UserDTO userDTO = userService.updateUser(dto);
        UserResponse userResponse = new UserResponse(userDTO);
        return ResponseEntity.ok(userResponse);
    }
}
