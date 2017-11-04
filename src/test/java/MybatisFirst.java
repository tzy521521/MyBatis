import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MybatisFirst {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init()throws IOException{
        String resource="mybatis/sqlMapConfig.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User(2,"tzy",new Date(),"meal","HeNan");
        try {
            sqlSession.update("updateByPrimaryKeySelective",user);
            sqlSession.commit();
        }catch (Exception e){

        }finally {
            sqlSession.close();
        }
        System.out.println(user);
    }
}
