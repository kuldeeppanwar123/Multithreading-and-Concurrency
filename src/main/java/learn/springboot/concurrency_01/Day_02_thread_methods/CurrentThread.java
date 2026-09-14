package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class CurrentThread {
  public static void main(String[] args) {
    Thread t1 = new Thread(()->{
      System.out.println(Thread.currentThread().getName());
    });

    t1.setName("worker 1");
    t1.start();
    System.out.println(Thread.currentThread().getName());
  }
}
