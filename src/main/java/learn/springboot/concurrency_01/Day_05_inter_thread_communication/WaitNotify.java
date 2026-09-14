package learn.springboot.concurrency_01.Day_05_inter_thread_communication;

public class WaitNotify {
  public static void main(String[] args) {
    Box2 box = new Box2();
    Thread t1 = new Thread(()-> {
      for (int i = 1; i <= 5; i++) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        try {
          box.producer(i);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        try {
          box.consumer();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    t1.start();
    t2.start();
  }
}

class Box2 {
  Integer item;
  volatile Boolean flag = false;


  synchronized void producer(int val) throws InterruptedException {
    while(flag==true) {
      wait();
    }
    item = val;
    flag = true;
    System.out.println("producer produces : " + item);
    notify();
  }

synchronized void consumer() throws InterruptedException {
    while(flag==false) {
      wait();
    }
    System.out.println("consumer consumes : " + item);
    item = null;
    flag = false;
    notify();
  }
}

// Thread communication
// shared resource ==>  Box->item
//  condition ==> box has item or not
//  waiting  ==> consumer wait if item is null, producer wait if item has value
//  notify ==> when consumer consumes item, it will notify producer that now it can produce item
//  producer ==> produce item and notify consumer


// wait():
//1. Release monitor lock
//2. It goes to WAITING state
//3. It stay there until it is notified by another thread
// it can be called in synchronized method only

//notify():
//1. It pick up one random thread from waiting queue
//2. It moves that thread to BLOCKED state
//3. That thread will compete for monitor lock
//4. Once lock occupied it will go to RUNNABLE state
//5. It can be called in synchronized method only

// notifyAll():
//1. It pick up all threads from waiting queue
//2. It moves all those threads to BLOCKED state
//3. Those threads will compete for monitor lock
//4. Only one gets the lock at a time and it will go to RUNNABLE state
//5. It can be called in synchronized method only


// notify can cause Deadlock always use notifyAll()
// spurious wakeup: sometime thread can come from waiting state to block state without notify but it is very rare.
// due to spurious wakeup we always use wait() method in loop (called guarded block)
