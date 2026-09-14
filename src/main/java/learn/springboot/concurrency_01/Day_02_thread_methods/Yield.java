package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Yield {
  public static void main(String[] args) {
   Thread t1 = new Thread(() -> {
     for (int i = 0; i <= 10; i++) {
       System.out.println("T1 : "+ i);
       Thread.yield();
     }
   });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i <= 10; i++) {
        System.out.println("T2 : "+ i);
      }
    });

    t1.start();
    t2.start();

  }
}


//Thread.yield():  I am willing to give my cpu time to someone else with same priority and that wants to run
// This is just request, OS can reject this
// current thread does not goes to WAITING, TIMED_WAITING, BLOCKED state, it does go to only RUNNABLE state