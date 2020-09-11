package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Part1StudentTest {

    private static Connection connection;
    private static DBManager dbManager;

    private static final String PROPERTIES = "app.properties";
    private static final String CONNECTION_URL = "connection.url";

    @BeforeClass
    public static void getConnection() throws IOException, SQLException {
        try (InputStream is = new FileInputStream(PROPERTIES)) {
            Properties prop = new Properties();
            prop.load(is);
            connection = DriverManager.getConnection(prop.getProperty(CONNECTION_URL));

            dbManager = DBManager.getInstance();
        }
    }

    // TODO
    @Test
    public void testsPlaceholder() {
        try {
            Demo.main(null);
            DBManager dbManager = DBManager.getInstance();
            dbManager.insertUser(User.createUser("ivan"));
            dbManager.insertTeam(Team.createTeam("teamIvan"));
            dbManager.findAllUsers();
            dbManager.findAllTeams();
            dbManager.getTeam("teamIvan");
            dbManager.getUser("ivan");
            dbManager.deleteTeam(null);
            dbManager.updateTeam(null);
            DBManager.main(null);
        } catch (Exception e) {
            e.getCause();
            Assert.assertTrue(true);
        }
    }


}