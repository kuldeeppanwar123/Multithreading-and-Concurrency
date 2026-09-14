package learn.springboot.concurrency_01.Day_01_basics_of_multithreading;

public class ThreadStates {
  public static void main(String[] args) {
    Thread  currentThread = Thread.currentThread();
    Thread t1 = new Thread(()-> {
      System.out.println("Thread name: " + Thread.currentThread().getName());
      System.out.println("Thread state: " + Thread.currentThread().getState());
      System.out.println("Main thread state: " + currentThread.getState());
    });

    System.out.println(t1.getState());

    t1.start();

    System.out.println(t1.getState());

    try {
      Thread.sleep(2000);
    }catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(t1.getState());
  }
}
