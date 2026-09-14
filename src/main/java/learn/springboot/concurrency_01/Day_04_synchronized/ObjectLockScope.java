package learn.springboot.concurrency_01.Day_04_synchronized;

public class ObjectLockScope {
  public static void main(String[] args) {
    Test2 test2 = new Test2();
    Test2 test3 = new Test2();
    Thread t1 = new Thread(()-> test2.m1());
    Thread t2 = new Thread(()-> test3.m1());

    t1.start();
    t2.start();
  }
}

class Test2 {
  synchronized void m1(){
    System.out.println("m1 enter");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("m1 exit");
  }

  synchronized void m2(){
    System.out.println("m2 enter");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("m2 exit");
  }
}

// synchronized methods are locked on the object instance. If one thread is executing a synchronized method, other threads that invoke any synchronized method on the same object will be blocked until the first thread exits the method. This ensures that only one thread can access the synchronized methods of an object at a time, preventing race conditions and ensuring thread safety.