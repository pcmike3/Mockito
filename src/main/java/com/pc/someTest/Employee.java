package com.pc.someTest;

import lombok.Getter;
import lombok.Setter;

/**
 * @author panchi
 * @Type Employee.java
 * @Desc
 * @date 2020/3/16 11:55
 */
@Getter
@Setter
public class Employee {
    private String name;
    private Integer age;
    private String dept;

    public Employee(String name, Integer age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
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
