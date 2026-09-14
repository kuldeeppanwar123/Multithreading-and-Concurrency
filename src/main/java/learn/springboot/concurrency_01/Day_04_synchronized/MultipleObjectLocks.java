package learn.springboot.concurrency_01.Day_04_synchronized;

public class MultipleObjectLocks {
  public static void main(String[] args) throws Exception{
    Bank bank = new Bank();
//    Thread t1 = new Thread(()-> {
//      try {
//        bank.deposit();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    });
//    Thread t2 = new Thread(()-> {
//      try {
//        bank.withdraw();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    });

    Thread t1 = new Thread(()-> bank.m1());

    Thread t2 = new Thread(()-> bank.m1());
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}

class Bank{
  Object lock1 = new Object();
  Object lock2 = new Object();


  void deposit() throws InterruptedException {
    synchronized (lock1) {
      Thread.sleep(2000);
      System.out.println("Amount deposite");
    }
  }

  void withdraw() throws InterruptedException {
    synchronized (lock2) {
      Thread.sleep(2000);
      System.out.println("Amount withdraw");
    }
  }

  void m1() {
    synchronized (new Object()) {
      System.out.println("m1 starts, Thread : " + Thread.currentThread().getName());
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("m1 ends, Thread : " + Thread.currentThread().getName());

    }
  }
}