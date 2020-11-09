package com.harry.test;

import com.harry.bean.team;
import com.harry.dao.TeamDao;
import com.harry.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeamTest01 {
    private TeamDao teamDao;
    private SqlSession sqlSession;

    @Before
    public void initTeamDao() {
        sqlSession = MyBatisUtil.getSqlSession();
        teamDao = sqlSession.getMapper(TeamDao.class);
    }

    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    @Test
    public void selectTeamByIdAlone(){
        team team = teamDao.selectTeamByIdAlone(1);
        System.out.println(team );

    }
}
