package learn.springboot.concurrency_01.Day_07_lock_free_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
  public static void main(String[] args) {
    Counter2 c = new Counter2();
    Runnable task = ()->{
      for(int i=0;i<1000;i++)
        c.increment();
    };
    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task);
    t1.start();
    t2.start();
    try {
//      t1.join();
//      t2.join();
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(c.count);
  }
}


class Counter {
  int count = 0;
  public void increment() {
    count++;
  }
}

class Counter2 {
  AtomicInteger count = new AtomicInteger(0);
  public void increment() {
    count.getAndIncrement();
  }
}
