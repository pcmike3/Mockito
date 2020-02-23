package com.pc.mybatisGenerator;

import com.pc.mybatisGenerator.model.auto.User;
import com.pc.mybatisGenerator.model.auto.UserExample;
import com.pc.mybatisGenerator.model.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestGeneratorDemo {

    @Autowired
   private UserMapper um;

    @Test
    public void test1() {
        UserExample ue = new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();
        criteria.andSexEqualTo("1");
        List<User> users = um.selectByExample(ue);
        System.out.println(users);
    }
}
