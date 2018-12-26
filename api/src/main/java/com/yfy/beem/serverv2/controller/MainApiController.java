package com.yfy.beem.serverv2.controller;

import com.yfy.beem.serverv2.dao.UserDao;
import com.yfy.beem.serverv2.datamodel.User;
import com.yfy.beem.serverv2.util.Mappings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller that handles all the REST API endpoint requests
 * */
@Slf4j
@Controller
@RequestMapping(Mappings.API_ROOT)
public class MainApiController {
    private final UserDao userDao;

    @Autowired
    public MainApiController(UserDao userDao) {
        this.userDao = userDao;
        log.info("finished instantiating MainApiController {}", this);
    }

    @GetMapping(Mappings.GET_USERS)
    public User[] getUsers(@RequestParam(required = false) Long id,
                           @RequestParam(required = false) String name) {
        List<User> users = userDao.getUsers();
        return (User[]) users.stream()
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
    }


}
