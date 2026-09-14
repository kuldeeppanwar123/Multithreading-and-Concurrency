package learn.springboot.concurrency_01.Day_04_synchronized;

public class ClassVsObjectLock {
  public static void main(String[] args) {

    Test3 t = new Test3();
    Thread t1 = new Thread(()-> t.m1());
    Thread t2 = new Thread(()-> t.m2());

    t1.start();
    t2.start();
  }
}

class Test3 {
   static void m1(){
     synchronized(Test3.class) {
       System.out.println("m1 enter");
       try {
         Thread.sleep(3000);
       } catch (InterruptedException e) {
         throw new RuntimeException(e);
       }
       System.out.println("m1 exit");
     }
  }

  void m2() {
     synchronized (this) {
       System.out.println("m2 enter");
       try {
         Thread.sleep(3000);
       } catch (InterruptedException e) {
         throw new RuntimeException(e);
       }
       System.out.println("m2 exit");
     }
   }
}

// synchronized methods are locked on the object instance. If one thread is executing a synchronized method, other threads that invoke any synchronized method on the same object will be blocked until the first thread exits the method. This ensures that only one thread can access the synchronized methods of an object at a time, preventing race conditions and ensuring thread safety.