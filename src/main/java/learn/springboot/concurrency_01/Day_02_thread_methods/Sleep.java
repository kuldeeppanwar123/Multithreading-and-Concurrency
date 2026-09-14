package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Sleep {
  public static void main(String[] args) {
    System.out.println("main thread starts");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }
    System.out.println("main thread ends");
//    Runnable -> TIMED_WAITING -> Runnable
//    sleep never release lock
  }
}
