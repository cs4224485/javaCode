package com.harry.dao;

import com.harry.bean.Player;

import java.util.List;

public interface PlayerDao {
    Player selectPlayerById(int id);
    List<Player> selectPlayer();
}
