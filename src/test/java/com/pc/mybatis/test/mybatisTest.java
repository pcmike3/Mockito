package com.pc.mybatis.test;

import com.pc.mybatis.dao.IUserDao;
import com.pc.mybatis.domain.QueryVo;
import com.pc.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


//1.读取配置文件
//2.创建sqlSessionFactory工厂
//3.使用工厂创建sqlSession对象
//4.使用sqlSession创建Dao接口的代理对象
//5.使用代理对象执行方法
//6.释放资源

public class mybatisTest {

    private IUserDao userDao;
    private InputStream in;
    private SqlSession session;

    @Before
    public void init() throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂创建sqlSession对象
        session = factory.openSession();
        //4.使用sqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void after() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }


    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserAddress("厦门");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        user.setUsername("zhaoqi");
        //5.使用代理对象执行方法
        userDao.saveUser(user);
    }

    @Test
    public void testDelete() {
        //5.使用代理对象执行方法
        userDao.deleteUser(3);
    }

    @Test
    public void testUpdate() {
        User user=new User();
        user.setUsername("liliu");
        user.setUserSex("1");
        user.setUserBirthday(new Date());
        user.setUserAddress("河南");
        user.setUserId(1);
        //5.使用代理对象执行方法
        userDao.updateUser(user);
    }

    @Test
    public void testFindById() {

        //5.使用代理对象执行方法
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {

        List<User> users = userDao.findByName("li%");
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        Integer total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testQueryVo() {
        User user = new User();
        user.setUsername("%li%");
        QueryVo vo=new QueryVo();
        vo.setUser(user);
        List<User> users = userDao.findByQueryVo(vo);
        for (User u:users){
            System.out.println(u);
        }

    }
    @Test
    public void test(){
        User u = new User();
        u.setUsername("1");
        System.out.println(u);
        u.setUsername(null);
        System.out.println(u);
    }


}
