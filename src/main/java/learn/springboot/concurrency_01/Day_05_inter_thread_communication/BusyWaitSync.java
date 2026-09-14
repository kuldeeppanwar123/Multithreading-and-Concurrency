package learn.springboot.concurrency_01.Day_05_inter_thread_communication;

public class BusyWaitSync {
  public static void main(String[] args) {
    Box1 box = new Box1();
    Thread t1 = new Thread(()-> {
      for (int i = 1; i <= 5; i++) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        box.producer(i);
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        box.consumer();
      }
    });
    t1.start();
    t2.start();
  }
}

class Box1 {
  Integer item;
  volatile Boolean flag = false;


  synchronized void producer(int val) {
    while(flag==true) {}
    item = val;
    flag = true;
    System.out.println("producer produces : " + item);
  }

synchronized void consumer() {
    while(flag==false) {}
    System.out.println("consumer consumes : " + item);
    item = null;
    flag = false;
  }
}