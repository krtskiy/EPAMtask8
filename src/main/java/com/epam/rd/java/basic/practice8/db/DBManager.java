package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import javax.security.auth.login.Configuration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class DBManager {

    private static final Logger LOG = Logger.getLogger("DBManager".getClass().getName());

    private static DBManager dbManager;

    private DBManager() {
    }

    public static DBManager getInstance() {
        return null;
    }

    public Connection getConnection(String connectionUrl) throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }

    public void insertUser(User login) {
    }

    public List<User> findAllUsers() {
        return null;
    }

    public void insertTeam(Team teamB) {
    }

    public List<Team> findAllTeams() {
        return null;
    }

    public User getUser(String login) {
        return null;
    }

    public Team getTeam(String name) {
        return null;
    }

    public void setTeamsForUser(User user, Team team) {
    }

    public void setTeamsForUser(User user, Team team1, Team team2) {
    }

    public void setTeamsForUser(User user, Team team1, Team team2, Team team3) {
    }

    public List<Team> getUserTeams(User user) {
        return null;
    }

    public void deleteTeam(Team team) {
    }

    public void updateTeam(Team team) {
    }

    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("app.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);

            dbManager = new DBManager();
            dbManager.getConnection(prop.getProperty("connection.url"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
