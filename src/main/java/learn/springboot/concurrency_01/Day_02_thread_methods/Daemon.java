package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Daemon {
  public static void main(String[] args) {
    Thread t1 = new Thread(()->{
      while(true){
        System.out.println("daemon thread");
      }
    });
//    t1.setDaemon(true);
    t1.start();
  }
}

// Daemon Thread: Background running threads
// stop immediately once main thread is completed
// Thread types: Daemon threads, User threads

// Garbage collection -> Daemon thread




