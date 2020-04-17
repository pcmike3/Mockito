package com.pc.someTest;

import lombok.Getter;
import lombok.Setter;

/**
 * @author panchi
 * @Type User.java
 * @Desc
 * @date 2020/3/16 11:54
 */
@Getter
@Setter
public class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/16 panchi create
 */ 
