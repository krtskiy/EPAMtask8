package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Part1StudentTest {

    private static DBManager dbManager;

    @BeforeClass
    public static void preparingForTask1Tests() {
        dbManager = DBManager.getInstance();
    }

    @Test
    public void shouldInsertNewUser() {
        int usersLengthBefore = dbManager.findAllUsers().size();
        dbManager.insertUser(User.createUser("testUser"));
        int usersLengthAfter = dbManager.findAllUsers().size();

        Assert.assertEquals(usersLengthAfter, usersLengthBefore + 1);
    }
}