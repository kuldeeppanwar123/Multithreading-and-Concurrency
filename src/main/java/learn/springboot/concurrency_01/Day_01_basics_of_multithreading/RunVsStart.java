package learn.springboot.concurrency_01.Day_01_basics_of_multithreading;

public class RunVsStart {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName());

    Thread t1 = new Thread(()-> System.out.println(Thread.currentThread().getName()));
    Thread t2 = new Thread(()-> System.out.println(Thread.currentThread().getName()));

    t1.run();
    t2.start();
  }
}
