package learn.springboot.concurrency_01.Day_03_problems_in_multithreading;

// Race condition
public class RaceCondition {
  public static void main(String[] args) {
    Counter counter = new Counter();
    Thread t1 = new Thread(()->{
      for(int i=0;i<1000;i++) counter.inc();
    });
    Thread t2 = new Thread(()->{
      for(int i=0;i<1000;i++) counter.inc();
    });
    t1.start();

    t2.start();
    System.out.println(counter.inc());
  }
}

class Counter {
  private int count = 0;
  public int inc() { return ++count; }
}