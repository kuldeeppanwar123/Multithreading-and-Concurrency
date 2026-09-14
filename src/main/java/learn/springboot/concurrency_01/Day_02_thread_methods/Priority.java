package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Priority {
  public static void main(String[] args) {
    Thread t1 = new Thread(()->{
      for(int i = 0; i < 5; i++){
        System.out.println("worker 1 : "+i);
      }
    });

    Thread t2 = new Thread(()->{
      for(int i = 0; i < 5; i++){
        System.out.println("worker 2 : "+i);
      }
    });

    t1.setPriority(10);
    t1.start();
    t2.start();
    System.out.println("t1 priority : "+t1.getPriority());
  }
}

//  Priority of thread varies from 1 to 10
// default priority of thread is 5
// if we don't set priority, it will be 5
// if we set priority more than 10, it will be set to 10
// if we set priority less than 1, it will be set to 1
//  OS scheduler decides which thread to run based on priority
//  but it is not guaranteed that higher priority thread will run first
// setting priority is just a request to OS not a guarantee