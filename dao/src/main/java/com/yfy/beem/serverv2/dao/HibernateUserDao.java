package com.yfy.beem.serverv2.dao;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import com.yfy.beem.serverv2.datamodel.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link UserDao} that accesses a cloud database with Hibernate.
 */
@Service
@Slf4j
public class HibernateUserDao implements UserDao {
    private final UserRepository userRepository;

    @Autowired
    public HibernateUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
        log.info("finished creating UserDao, {}", this);
    }

    @Override
    public List<User> getUsers() {
        return ImmutableList.copyOf(userRepository.findAll());
    }


    @Override
    public List<User> getUsersByName(String name) {
        List<User> users = Streams
                .stream(userRepository.findAll())
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
        return ImmutableList.sortedCopyOf(Comparator.comparing(User::getName), users);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
