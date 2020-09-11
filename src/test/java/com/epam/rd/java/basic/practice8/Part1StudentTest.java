package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
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

    @Test
    public void demoMainTestPlaceholder() {
        Demo.main(null);
        Assert.assertTrue(true);
    }

    @Test
    public void dbManagerMainTestPlaceholder() {
        DBManager.main(null);
        Assert.assertTrue(true);
    }


}