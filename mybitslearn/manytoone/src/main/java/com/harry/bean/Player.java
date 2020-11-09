package com.harry.bean;

/**
 * 运动员
 */
public class Player {
    private int id;
    private String name;

    public com.harry.bean.team getTeam() {
        return team;
    }

    public void setTeam(com.harry.bean.team team) {
        this.team = team;
    }

    private team team;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}
