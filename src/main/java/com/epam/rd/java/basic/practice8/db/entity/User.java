package com.epam.rd.java.basic.practice8.db.entity;

import java.util.Objects;

public class User {

    private String login;

    public static User createUser(String login) {
        User user = new User();
        user.setLogin(login);
        return user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

}
