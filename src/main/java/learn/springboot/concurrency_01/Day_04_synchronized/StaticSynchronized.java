package learn.springboot.concurrency_01.Day_04_synchronized;

// static synchronization
public class StaticSynchronized {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(()->{
       Counter1.increment();
    });
    Thread t2 = new Thread(()->{
       Counter1.increment();
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Count: " + Counter1.count);
  }
}

class Counter1 {
  static int count = 0;

   static void increment() {
     synchronized (Counter1.class) {
       try {
         Thread.sleep(2000);
       } catch (InterruptedException e) {
         throw new RuntimeException(e);
       }
       count++;
     }
   }
}