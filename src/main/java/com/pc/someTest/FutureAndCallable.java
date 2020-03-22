package com.pc.someTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author panchi
 * @Type FutureAndCallable.java
 * @Desc
 * @date 2020/3/22 15:04
 */

public class FutureAndCallable {
    //第1种使用future和callable的方式
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable<Integer> callable = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 1;
//            }
//        };
//        FutureTask<Integer> future = new FutureTask<>(callable);
//        new Thread(future).start();
//        System.out.println(future.get());
//    }


    //第2种使用future和callable的方式
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Map> future = service.submit(new Callable<Map>() {
            @Override
            public Map call() throws Exception {
                Map map = new HashMap();
                for (int i = 0; i < 5; ++i) {
                    map.put(i,i);
                }
                return map;
            }
        });
        System.out.println(future.get());
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/22 panchi create
 */ 
