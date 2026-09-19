package learn.springboot.concurrency_01.Day_08_executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    for (int i = 0; i < 5; i++) {
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
