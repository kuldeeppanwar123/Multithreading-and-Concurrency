package learn.springboot.concurrency_01.Day_06_java_locks;

import java.util.concurrent.locks.StampedLock;

// stampedlock
public class StampedLockDemo {
  public static void main(String[] args) {
    SharedResource resource = new SharedResource();
    Thread reader1 = new Thread(() -> resource.read(), "reader1");
    Thread reader2 = new Thread(() -> resource.read(), "reader2");

    Thread writer1 = new Thread(() -> resource.write(10), "writer1");
    Thread writer2 = new Thread(() -> resource.write(20), "writer2");

    reader1.start();
    reader2.start();
    writer1.start();
    writer2.start();
  }
}

class SharedResource {
  private int value = 0;

  StampedLock lock = new StampedLock();

  public int read() {
    long stamp = lock.tryOptimisticRead();
    int currentVal = value;
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if(lock.validate(stamp)==false) {
//  try passimistic read
      stamp = lock.readLock();
      try {
        currentVal = value;
      } finally {
        lock.unlockRead(stamp);
      }
    }

    System.out.println(Thread.currentThread().getName()+" read value as "+currentVal);
    return currentVal;
  }

  public void write(int val) {
    long stamp = lock.writeLock();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    this.value = val;
    System.out.println(Thread.currentThread().getName()+" updated value to "+val);
    lock.unlockWrite(stamp);

  }
}