package learn.springboot.concurrency_01.Day_06_java_locks;

import java.util.concurrent.Semaphore;

// Semaphore
public class SemaphoreDemo {
  public static void main(String[] args) {
    SharedResource2 resource = new SharedResource2();
    Thread reader1 = new Thread(() -> resource.read(), "reader1");
    Thread reader2 = new Thread(() -> resource.read(), "reader2");
    Thread reader3 = new Thread(() -> resource.read(), "reader3");
    Thread reader4 = new Thread(() -> resource.read(), "reader4");

    reader1.start();
    reader2.start();
    reader3.start();
    reader4.start();
  }
}

class SharedResource2 {
  private Semaphore semaphore = new Semaphore(2);

  public void read(){
    try {
      semaphore.acquire();
      System.out.println(Thread.currentThread().getName()+" is reading");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }
}

//A semaphore with 1 permit is called mutex.
// we normally implement mutex-style mutual exclusion using ReentrantLock or synchronized.