package com.epam.rd.java.basic.practice8.db.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author D.Koretskyi on 15.09.2020.
 */
public class TeamTest {

    @Test
    public void teamHashCodeTest() {
        Team team1 = Team.createTeam("testTeam1");
        Team team2 = Team.createTeam("testTeam2");
        Assert.assertNotEquals(team1.hashCode(), team2.hashCode());
    }

    @Test
    public void teamEqualsTest() {
        Team team1 = Team.createTeam("testTeam1");
        Team team2 = Team.createTeam("testTeam2");
        Assert.assertNotEquals(team1, team2);
    }

}