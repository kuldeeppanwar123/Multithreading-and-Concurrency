package learn.springboot.concurrency_01.Day_07_lock_free_concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CAS {
  public static void main(String[] args) {
    LikeCounter lc = new LikeCounter();
    LikeCounter2 lc2 = new LikeCounter2();

    Thread t1 = new Thread(() -> {
      for(int i = 0; i < 1000; i++) lc.like();
    });
    Thread t2 = new Thread(() -> {
      for(int i = 0; i < 1000; i++) lc.like();
    });
    Thread t3 = new Thread(() -> {
      for(int i = 0; i < 1000; i++) lc.like();
    });
    Thread t4 = new Thread(() -> {
      for(int i = 0; i < 1000; i++) lc.like();
    });
    t1.start();
    t2.start();
    t3.start();
    t4.start();

    try {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(lc.count);
  }
}

class LikeCounter {
  AtomicReference<Integer>count = new AtomicReference<>(0);

  public void like() {
    Integer currentCount;
    Integer newCount;
    while(true) {
       currentCount = count.get();
       newCount = currentCount + 1;
      if (count.compareAndSet(currentCount, newCount)) break;
      System.out.println("conflict");
//   if reaches here means other thread
//   changed the value of count, so we retry

    }
  }
}

class LikeCounter2 {
AtomicInteger count = new AtomicInteger(0);
  public void like() {
    count.incrementAndGet();
  }
}

// in locking only one thread enters in critical section
// in CAS all threads enter the critical section but only one succeeds in updating the value, others retry until they succeed.
// CAS stands for Compare And Swap
// CAS not solves ABA problem