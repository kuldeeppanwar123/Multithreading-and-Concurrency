package learn.springboot.concurrency_01.Day_08_executor_framework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
  public static void main(String[] args) {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

    for (int i = 0; i < 10; i++) {
      int taskId = i;
      executor.execute(() -> {
        System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
    executor.shutdown();
  }
}
