package util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolAndCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        // 线程安全的计数器
        final AtomicInteger totalRows = new AtomicInteger(0);

        // 创建线程池，其中核心线程10，也是我期望的最大并发数，最大线程数和队列大小都为30，即我的总任务数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30, 60L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30));

        //或者ExecutorService executor = Executors.newFixedThreadPool(corePoolSize);

        // 初始化CountDownLatch，大小为30
        final CountDownLatch countDownLatch = new CountDownLatch(30);

        // 模拟遍历参数集合
        for (int i = 0; i < 30; i++) {
            // 往线程池提交任务
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    int times = 0;
                    // 模拟数据拉取过程可能需要分页
                    while (times < 5) {
                        // 模拟每个任务需要分页5次
                        times++;
                        // 模拟计数
                        totalRows.incrementAndGet();
                        try {
                            // 模拟耗时
                            Thread.sleep(Long.parseLong(String.valueOf(new Double(Math.random() * 1000).intValue())));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 子线程完成，countDownLatch执行countDown
                    countDownLatch.countDown();
                }
            });
            // 打印线程池运行状态
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行结束的任务数目：" + executor.getCompletedTaskCount());
        }
        // 标记多线程关闭，但不会立马关闭
        executor.shutdown();

        // 阻塞当前线程，知道所有子线程都执行countDown方法才会继续执行
        countDownLatch.await();

        // 打印线程池运行状态
        System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                executor.getQueue().size() + "，已执行结束的任务数目：" + executor.getCompletedTaskCount());

        // 打印计数
        System.out.println("结束：" + totalRows.get());
    }
}