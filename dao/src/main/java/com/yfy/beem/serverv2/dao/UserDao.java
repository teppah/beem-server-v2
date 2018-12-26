package com.yfy.beem.serverv2.dao;

import com.yfy.beem.serverv2.datamodel.User;

import java.util.List;

/**
 * Abstraction layer for accessing database user data.
 * */
public interface UserDao {
    /**
     * Get an unmodifiable {@link List} of all {@link User}s stored in database.
     *
     * @return {@link List} of all {@link User}s stored in database
     * */
    List<User> getUsers();
    /**
     * Get an unmodifiable {@link List} of all {@link User}s matching name stored in database.
     *
     * @param name the name of the user to search for
     * @return {@link List} of all {@link User}s matching name stored in database.
     * */
    List<User> getUsersByName(String name);
    /**
     * Get an {@link User} by id, if it exists
     * @param id the id of the {@link User}
     * @return the matching {@link User}, otherwise {@code null}
     * */
    User getUserById(Long id);
    /**
     * Add a {@link User} to the database.
     * @param user the {@link User} that will be stored
     * */
    void addUser(User user);
    /**
     * Remove an {@link User} by Id.
     * @param userId the id of the user
     * */
    void removeUserById(Long userId);
}
