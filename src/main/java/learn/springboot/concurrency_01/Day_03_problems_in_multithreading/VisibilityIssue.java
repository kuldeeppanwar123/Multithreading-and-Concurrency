package learn.springboot.concurrency_01.Day_03_problems_in_multithreading;
// visibility issue
public class VisibilityIssue {
volatile static boolean  flag = false;

  public static void main(String[] args) {
    Thread  t1 = new Thread(()->{
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      flag = true;
    });

    Thread t2 = new Thread(()->{

      while(!flag){
//        System.out.println("Flag is false");  syncronized
      }
      System.out.println("Flag is true");
    });
    t1.start();
    t2.start();
  }
}
