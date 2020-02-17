package com.pc.Lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LambdaDemoTest {

    @Test
    public void test1(){
        List<Integer> list= Arrays.asList(1,2,3,4,5);
//        list.stream().map((a)->a.toUpperCase()).forEach(System.out::println);
//        list.stream().sorted().forEach(System.out::println);
//        Integer a= list.stream().reduce();
//        System.out.println(a);
        //list.stream().sorted((e1,e2)->{return e2.compareTo(e1);}).forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Employee> list = Arrays.asList(
                new Employee("张三",12,43.2, Employee.Status.BUSY),
                new Employee("李四",13,132.2, Employee.Status.FREE),
                new Employee("王五",14,543.2, Employee.Status.VOCATION),
                new Employee("王五",14,543.2, Employee.Status.VOCATION)
        );
        //list.stream().collect(Employee::getName);
        //list.stream().map(Employee::getName).sorted((a,b)->{return a.compareTo(b);}).forEach(System.out::println);
//        Optional<Double> reduce = list.stream().map(Employee::getSalary).reduce(Double::sum);
//        System.out.println(reduce.get());
        Long collect = list.stream().map(Employee::getAge).collect(Collectors.counting());
        System.out.println(collect);

    }


    @Test
    public void test3(){
        List list=Arrays.asList(1,2);
        Set set=new HashSet(Arrays.asList(1,2,3));
        Map map = new HashMap(){{
            put("1",1);
        }};
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }

    @Test
    public void test4(){
        Integer[] i = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(i);
        list.stream().map((x)->x*x).forEach(System.out::println);
        //System.out.println(list);
    }

    @Test
    public void test5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Employee> list1 = Arrays.asList(
                new Employee("张三",12,43.2, Employee.Status.BUSY),
                new Employee("李四",13,132.2, Employee.Status.FREE),
                new Employee("王五",14,542.2, Employee.Status.VOCATION),
                new Employee("王d 五",14,541.2, Employee.Status.VOCATION)
        );
        Double count = list1.stream().collect(Collectors.summingDouble(Employee::getSalary));
        Optional<Double> reduce = list1.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(count);
        System.out.println(reduce);
    }

    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        list.stream().map(x->x+1).forEach(System.out::println);
    }

    @Test
    public void test7(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }


    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test9(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test10(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test11(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test12(){
        List<Integer> list = Arrays.asList(1,2,4,5,6);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

}
