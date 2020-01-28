package com.isc.ipnew;

import com.isc.ipnew.dao.dto.RoleDTO;
import com.isc.ipnew.dao.dto.UserDTO;
import com.isc.ipnew.service.UserService;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitializeDb {

    private final UserService userService;

    public InitializeDb(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    @Order(2)
    private void createUser() {

        RoleDTO admin = new RoleDTO();
        admin.setTitle("ادمین سامانه");
        admin.setRole("ADMIN");

        RoleDTO client = new RoleDTO();
        client.setTitle("کاربر سامانه");
        client.setRole("CLIENT");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserDTO admin1 = new UserDTO();
        admin1.setFirstName("رضا");
        admin1.setLastName("روشنی");
        admin1.setUsername("admin");
        admin1.setPassword(bCryptPasswordEncoder.encode("admin"));
        Set<RoleDTO> roles = new HashSet<>();
        roles.add(admin);
        roles.add(client);
        admin1.setRoles(roles);
        userService.addUser(admin1);

        for (int i = 1; i <= 20; i++) {
            UserDTO clientz = new UserDTO();
            clientz.setFirstName("user " + i);
            clientz.setLastName("user family " + i);
            clientz.setUsername("client " + i);
            clientz.setPassword(bCryptPasswordEncoder.encode("client" + i));
            Set<RoleDTO> roleList = new HashSet<>();
            roleList.add(client);
            clientz.setRoles(roleList);
            userService.addUser(clientz);
        }
    }
}
