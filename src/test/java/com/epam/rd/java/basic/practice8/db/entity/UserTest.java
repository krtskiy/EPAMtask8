package com.epam.rd.java.basic.practice8.db.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author D.Koretskyi on 15.09.2020.
 */
public class UserTest {

    @Test
    public void userHashCodeTest() {
        User user1 = User.createUser("testUser1");
        User user2 = User.createUser("testUser2");
        Assert.assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void userEqualsTest() {
        User user1 = User.createUser("testUser1");
        User user2 = User.createUser("testUser2");
        Assert.assertNotEquals(user1, user2);
    }

}