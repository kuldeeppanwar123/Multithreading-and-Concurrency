package learn.springboot.concurrency_01.Day_04_synchronized;

public class SynchronizedMethod {
  public static void main(String[] args) {
    Test test = new Test();
    Thread t1 = new Thread(()-> test.show());
    Thread t2 = new Thread(()-> test.show());

    t1.start();
    t2.start();
  }
}

class Test {
  synchronized void show() {
    System.out.println("Inside show, Thread: "+Thread.currentThread().getName() + " is running");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Ending show, Thread: "+Thread.currentThread().getName() + " has finished");
  }
}

// synchronized uses:
// To protect shared resources
// To make operation atomic
// To ensure visibility
// To prevent ordering


// syncronized is also called monitor locks or object locks