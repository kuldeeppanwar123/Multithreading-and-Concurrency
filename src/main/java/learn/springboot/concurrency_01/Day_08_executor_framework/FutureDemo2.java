package learn.springboot.concurrency_01.Day_08_executor_framework;

import java.util.List;
import java.util.concurrent.*;

public class FutureDemo2 {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
//    ExecutorService executor = Executors.newFixedThreadPool(2);
//    List<Callable<Integer>> tasks = List.of(
//        ()->10,
//        ()->20,
//        ()->30
//    );
//
//    List<Future<Integer>> futures = executor.invokeAll(tasks);
//
//    for(Future<Integer> future : futures){
//      System.out.println(future.get());
//    }

    ExecutorService executor = Executors.newFixedThreadPool(3);

    List<Callable<String>> tasks = List.of(
        () -> {
          Thread.sleep(5000);
          return "Server A";
        },
        () -> {
          Thread.sleep(2000);
          return "Server B";
        },
        () -> {
          Thread.sleep(4000);
          return "Server C";
        }
    );

    String result = executor.invokeAny(tasks);

    System.out.println(result);

    executor.shutdown();
  }
}
