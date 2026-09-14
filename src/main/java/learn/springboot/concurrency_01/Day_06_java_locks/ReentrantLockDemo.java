package learn.springboot.concurrency_01.Day_06_java_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
  public static void main(String[] args) {
    Resource resource = new Resource();
    Thread t1 = new Thread(() -> {
      resource.method();
    }, "T1");
    Thread t2 = new Thread(() -> {
      resource.method();
    }, "T2");
    t1.start();
    t2.start();
  }
}

class Resource  {
  Lock lock = new ReentrantLock();

  void method() {
  lock.lock();
  lock.lock();
  try {
    System.out.println("Thread " + Thread.currentThread().getName() + " entered.");
    Thread.sleep(2000);
    System.out.println("Thread " + Thread.currentThread().getName() + " exiting.");
  } catch (InterruptedException e) {
    throw new RuntimeException(e);
  } finally {
    lock.unlock();
  }
  }
}