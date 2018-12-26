package com.yfy.beem.serverv2;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class UserTest {
    private Random r;

    @Before
    public void setUp() throws Exception {
        r = new Random();
    }

    @Test
    public void idTest() {
        User user = new User();
        Long id = r.nextLong();
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void nameTest() {
        User user = new User();
        String name = "akj2!$#zkk$#%J{{}Zlw425e";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    public void publicKeyTest() {
        User user = new User();
        String publicKey = "543jhn6jkl234JMV$%LFGNMLK$GN#$fn42lk56L$KNJFGlknLK^FCN@$fljk2$%flk2n";
        user.setPublicKey(publicKey);
        assertEquals(publicKey, user.getPublicKey());
    }

    @Test
    public void ipAddressTest() {
        User user = new User();
        String ipAddress = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
        user.setIpAddress(ipAddress);
        assertEquals(ipAddress, user.getIpAddress());
    }

    @Test
    public void equalsTest() {
        User user1 = new User();
        User user2 = new User();
        Long id = r.nextLong();
        user1.setId(id);
        user2.setId(id);
        user1.setName("NAME1");
        user2.setName("nAmE2");
        assertEquals(user1, user2);

        user1.setId(r.nextLong());
        assertNotEquals(user1,user2);
    }
}