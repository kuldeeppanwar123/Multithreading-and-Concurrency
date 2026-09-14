package learn.springboot.concurrency_01.Day_01_basics_of_multithreading;

public class ExtendThread {
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
  }
}

class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("Thread is running");
  }
}
