package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Alive {
  public static void main(String[] args) {
    Thread t1 = new Thread( ()->{
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {

      }
    });
    System.out.println(t1.isAlive()); // false
    t1.start();
    System.out.println(t1.isAlive());  // true
  }
}

//isAlive()   --> true bw start to terminate
