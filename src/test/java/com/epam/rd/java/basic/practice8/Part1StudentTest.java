package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part1StudentTest {

    private static DBManager dbManager;

    @Before
    public void preparingForTask1Tests() {
        dbManager = DBManager.getInstance();
    }

    @Test
    public void shouldInsertNewUser() {
        int usersLengthBefore = dbManager.findAllUsers().size();
        dbManager.insertUser(User.createUser("testUser"));
        int usersLengthAfter = dbManager.findAllUsers().size();

        Assert.assertEquals(usersLengthAfter, usersLengthBefore + 1);
    }

    @Test
    public void shouldReturnListOfUsers() {
        Assert.assertNotNull(dbManager.findAllUsers());
    }

    @Test
    public void testPlaceholder() {
        Demo.main(null);
        Assert.assertTrue(true);
    }


}