package learn.springboot.concurrency_01.Day_01_basics_of_multithreading;

public class MultipleThreads {
  public static void main(String[] args) {
    Thread t1 = new Thread(()-> {
      for (int i = 0; i < 100; i++) {
        if(i%2==0) {
          System.out.println("Thread t1 : " + i);
        }
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        if(i%2!=0) {
          System.out.println("Thread t2 : " + i);
        }
      }
    });

    t1.start();
    t2.start();
  }
}
