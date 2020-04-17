package com.pc.someTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author panchi
 * @Type 它.java
 * @Desc
 * @date 2020/3/16 16:50
 */

public class T5 {
    private static final ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        Callable<String> c1 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "::正在执行计算");
                return "AA";
            }
        };
        Callable<String> c2 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "::正在执行计算");
                Thread.sleep(3000);
                return "BB";
            }
        };
        Callable<String> c3 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "::正在执行计算");
                Thread.sleep(1000);
                return "CC";
            }
        };

        List<Callable<String>> list = new ArrayList<Callable<String>>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        List<Future<String>> futures = exec.invokeAll(list, 2000, TimeUnit.MILLISECONDS); //阻塞方法，当所有任务执行完毕，中断或超时时返回。

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                System.out.println("异常");
            } catch (CancellationException e) {
                System.out.println("超时");
            }
        }

        exec.shutdown();
    }
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/16 panchi create
 */ 
