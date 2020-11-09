package com.harry.bean;

import java.util.List;

public class team {
    private int id;
    private String name;
    private List<Player> playerList;

    public team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerList=" + playerList +
                '}';
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
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
}
