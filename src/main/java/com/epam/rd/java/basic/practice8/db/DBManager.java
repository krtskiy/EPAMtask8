package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class DBManager {

    private static final Logger LOG = Logger.getLogger("DBManager".getClass().getName());

    private static DBManager dbManager;

    private static final String PROPERTIES = "app.properties";
    private static final String SQL_SCRIPT_FILE = "sql/db-create.sql";
    private static final String CONNECTION_URL = "connection.url";
    private static String url;

    private static final String FIND_ALL_USERS = "SELECT * FROM users ORDER BY id";
    private static final String INSERT_USER = "INSERT INTO users VALUES (DEFAULT, ?)";
    private static final String FIND_ALL_TEAMS = "SELECT * FROM teams ORDER BY id";
    private static final String INSERT_TEAM = "INSERT INTO teams VALUES (DEFAULT, ?)";
    private static final String FIND_USER = "SELECT * FROM users WHERE login=?";
    private static final String FIND_TEAM = "SELECT * FROM teams WHERE name=?";

    private DBManager() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES)) {
            Properties prop = new Properties();
            prop.load(inputStream);
            url = prop.getProperty(CONNECTION_URL);
            executeScript(getConnection(url), new FileInputStream(SQL_SCRIPT_FILE));
        } catch (IOException | SQLException e) {
            LOG.severe(e.getMessage());
        }
    }

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String connectionUrl) throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }

    public void insertUser(User user) {
        try (PreparedStatement preparedStatement =
                     getConnection(url).prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.execute();

            ResultSet generatedId = preparedStatement.getGeneratedKeys();
            if (generatedId.next()) {
                user.setId(generatedId.getInt(1));
            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }
    }

    public List<User> findAllUsers() {
        List<User> listOfUsers = new ArrayList<>();
        try (Statement statement = getConnection(url).createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS)
        ) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                listOfUsers.add(user);
            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }
        return listOfUsers;
    }

    public void insertTeam(Team team) {
        try (PreparedStatement preparedStatement =
                     getConnection(url).prepareStatement(INSERT_TEAM, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, team.getName());
            preparedStatement.execute();

            ResultSet generatedName = preparedStatement.getGeneratedKeys();
            if (generatedName.next()) {
                team.setId(generatedName.getInt(1));
            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }
    }

    public List<Team> findAllTeams() {
        List<Team> listOfTeams = new ArrayList<>();
        try (Statement statement = getConnection(url).createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_TEAMS)
        ) {
            while (resultSet.next()) {
                Team team = new Team();
                team.setName(resultSet.getString("name"));
                team.setId(resultSet.getInt("id"));
                listOfTeams.add(team);
            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }
        return listOfTeams;
    }

    public User getUser(String login) {
        User user = null;
        try (PreparedStatement preparedStatement = getConnection(url).prepareStatement(FIND_USER)) {

            preparedStatement.setString(1, login);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login"));
                }
            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }

        return user;
    }

    public Team getTeam(String name) {
        Team team = null;
        try (PreparedStatement preparedStatement = getConnection(url).prepareStatement(FIND_TEAM)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    team = new Team();
                    team.setId(resultSet.getInt("id"));
                    team.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }
        return team;
    }

    public void setTeamsForUser(User user, Team ... team) {
    }

    public List<Team> getUserTeams(User user) {
        return null;
    }

    public void deleteTeam(Team team) {

    }

    public void updateTeam(Team team) {
        
    }

    public static void executeScript(Connection conn, InputStream in)
            throws SQLException {
        Scanner s = new Scanner(in);
        s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");

        Statement st = null;

        try {
            st = conn.createStatement();

            while (s.hasNext()) {
                String line = s.next().trim();

                if (!line.isEmpty())
                    st.execute(line);
            }
        } finally {
            if (st != null)
                st.close();
        }
    }

    public static void main(String[] args) {
        dbManager = getInstance();

        Team team = dbManager.getTeam("teamA");
        System.out.println(team);
        System.out.println(team.getId());

    }

}
