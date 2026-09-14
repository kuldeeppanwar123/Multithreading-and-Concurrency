package learn.springboot.concurrency_01.Day_01_basics_of_multithreading;

public class RunnableThread {
  public static void main(String[] args) {
//    MyRunnable r = new MyRunnable();
//    Thread t = new Thread(r);

    Thread t = new Thread(()-> System.out.println("Hyy"));
    t.start();
  }
}

class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("Thread is running");
  }
}