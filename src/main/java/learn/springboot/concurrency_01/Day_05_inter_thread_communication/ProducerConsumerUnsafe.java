package learn.springboot.concurrency_01.Day_05_inter_thread_communication;

public class ProducerConsumerUnsafe {
  public static void main(String[] args) {
    Box box = new Box();
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
          Thread.sleep(70);
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

class Box {
  Integer item;
  Boolean flag = false;


  void producer(int val) {
    item = val;
    flag = true;
    System.out.println("producer produces : " + item);
  }

  void consumer() {
    System.out.println("consumer consumes : " + item);
    item = null;
    flag = false;
  }
}