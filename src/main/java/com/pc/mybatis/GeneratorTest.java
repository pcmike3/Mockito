package com.pc.mybatis;

import com.pc.mybatisGenerator.model.auto.User;
import com.pc.mybatisGenerator.model.auto.UserExample;
import com.pc.mybatisGenerator.model.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class GeneratorTest {

    public static void main(String[] args) throws IOException {
        String resource = "sqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        UserExample example=new UserExample();
        example.createCriteria().andIdEqualTo(1);
        List<User> users = mapper.selectByExample(example);
        System.out.println(users);
    }
}
