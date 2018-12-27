package com.yfy.beem.serverv2.dao;

import com.yfy.beem.serverv2.dao.UserRepository;
import com.yfy.beem.serverv2.datamodel.User;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Streams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserDaoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private Random r;

    @Before
    public void setUp() {
        r = new Random();
    }

    @Test
    public void testFindById() {
        Long l = r.nextLong();
        entityManager.persist(User.builder().id(l).build());
        Optional<User> user = userRepository.findById(l);
        assertEquals(l, user.get().getId());

    }

    @Test
    public void testFindByName() {
        final String testName = "Spring Testing 123321";
        entityManager.persist(User.builder().name(testName).build());
        List<User> found = Streams
                .stream(userRepository.findAll())
                .filter(user -> user.getName().equals(testName))
                .collect(Collectors.toList());
        assertEquals(1, found.size());
        assertEquals(testName, found.get(0).getName());
    }

    @Test
    public void testGetAllUsers() {
        entityManager.persist(User.builder().id(r.nextLong()).build());
        entityManager.persist(User.builder().id(r.nextLong()).build());
        entityManager.persist(User.builder().id(r.nextLong()).build());
        entityManager.persist(User.builder().id(r.nextLong()).build());
        entityManager.persist(User.builder().id(r.nextLong()).build());

        List<User> users = Lists.newArrayList(userRepository.findAll());
        assertEquals(5, users.size());
    }
}
