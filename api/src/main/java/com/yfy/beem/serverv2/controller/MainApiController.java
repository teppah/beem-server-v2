package com.yfy.beem.serverv2.controller;

import com.yfy.beem.serverv2.dao.UserDao;
import com.yfy.beem.serverv2.datamodel.User;
import com.yfy.beem.serverv2.util.Mappings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller that handles all the REST API endpoint requests
 */
@Slf4j
@RestController
@RequestMapping(Mappings.API_ROOT)
public class MainApiController {
    private final UserDao userDao;

    @Autowired
    public MainApiController(UserDao userDao) {
        this.userDao = userDao;
        log.info("finished instantiating MainApiController {}", this);
    }

    @GetMapping(value = Mappings.GET_USERS)
    public Object[] getUsers(@RequestParam(required = false) Long id,
                             @RequestParam(required = false) String name) {
        List<User> users = userDao.getUsers();
        Object[] filteredUsers = users.stream()
                // filter by id
                .filter(user -> {
                    if (id != null) {
                        return user.getId().equals(id);
                    } else {
                        return true;
                    }
                })
                // filter by name
                .filter(user -> {
                    if (name != null) {
                        return user.getName().equalsIgnoreCase(name);
                    } else {
                        return true;
                    }
                })
                .toArray();
        log.info("found all users matching criteria id = {}, name = {}, as follows: {}", id, name, filteredUsers);
        return filteredUsers;
    }

    @PostMapping(value = Mappings.ADD_USER)
    public void addUser(@RequestParam Long id,
                        @RequestParam String name,
                        @RequestParam String publicKey,
                        HttpServletRequest request) {
        User user = User.builder()
                .id(id)
                .name(name)
                .publicKey(publicKey)
                .ipAddress(request.getRemoteAddr())
                .build();
        log.info("saving new user {}", user);
        userDao.addUser(user);
    }

    @DeleteMapping(value = Mappings.DELETE_USER)
    public void deleteUser(@RequestParam Long id) {
        log.info("deleting user by id '{}'", id);
        userDao.removeUserById(id);
    }

}
