package learn.springboot.concurrency_01.Day_04_synchronized;


// Race condition
public class SynchronizedBlock {
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
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(counter.count);
  }
}

class Counter {
  public int count = 0;
//  synchronized public int inc() { return ++count; }

  public void inc(){
//    other code
    synchronized (this){
      count++;
    }
//    other code
  }
}