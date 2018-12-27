package com.yfy.beem.serverv2.dao;

import com.yfy.beem.serverv2.datamodel.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Test for {@link UserDao} to see if the abstraction layer is working correctly.
 * */
@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserDaoTest {
    @Autowired
    private TestEntityManager entityManager;
//    @Autowired
//    private UserDao userDao;

    private Random r;

    @Before
    public void setUp() {
        r = new Random();
    }

    @Test
    public void testGetUsers() {
//        final int userToSave = 10;
//        for (int i = 0; i < userToSave; i++) {
//            entityManager.persist(User.builder().id(r.nextLong()));
//        }
//        List<User> saved = userDao.getUsers();
//        assertEquals(userToSave, saved.size());
    }

}
