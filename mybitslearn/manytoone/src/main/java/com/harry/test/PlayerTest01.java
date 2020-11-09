package com.harry.test;

import com.harry.bean.Player;
import com.harry.bean.team;
import com.harry.dao.PlayerDao;
import com.harry.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerTest01 {
    private PlayerDao playerDao;
    private SqlSession sqlSession;

    @Before
    public void initTeamDao() {
        sqlSession = MyBatisUtil.getSqlSession();
        playerDao = sqlSession.getMapper(PlayerDao.class);
    }

    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void selectPlayerById() {
        Player player = playerDao.selectPlayerById(1);
        System.out.println(player);

    }

    @Test
    public void selectPlayer() {
        List<Player> players = playerDao.selectPlayer();
        players.forEach(p -> {
            System.out.println(p);
        });
    }
}
