import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    /**
     * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     */
    @Test
    public void test() throws IOException {
        String resource = "mybatis.xml";
        //读取主配置文件
        InputStream stream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        List<Object> employees = sqlSession.selectList("selectEmployees");
        System.out.println(employees);
    }
}
