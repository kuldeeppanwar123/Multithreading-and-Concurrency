package learn.springboot.concurrency_01.Day_08_executor_framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executor = Executors.newFixedThreadPool(2);
    Future<Integer> future = executor.submit(() -> {
      System.out.println("Task executed by " + Thread.currentThread().getName());
      Thread.sleep(2000);
      return 42;
    });
    System.out.println("Task submitted");
    System.out.println("Result: " + future.get());
    System.out.println("Task completed: " );
    executor.shutdown();
  }
}

// future get() blocks the calling thread until the task is complete.
// Future represents the result of an asynchronous computation.
