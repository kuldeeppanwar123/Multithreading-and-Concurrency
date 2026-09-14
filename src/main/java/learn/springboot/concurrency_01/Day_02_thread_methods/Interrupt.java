package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Interrupt {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(()->{
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("running");
      }
    });

    t1.start();
    Thread.sleep(2000);
    t1.interrupt();










  }
}

// Thread  --> interrupt() : interrupt flag default false
// t1.interrupt()  -> send signal to t1 thread that it should stop doing what it is doing
// isInterrupted() --> return interrupt flag value (T/F)
// interrupted()  -->  return interrupt flag value(T/F) but also set it back to false
// sleep(), join(), wait() : TIMED_WAITING, WAITING  --> interrupt()   ==> InterruptedException