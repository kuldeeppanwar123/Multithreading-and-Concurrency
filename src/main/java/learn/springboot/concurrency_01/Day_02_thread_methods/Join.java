package learn.springboot.concurrency_01.Day_02_thread_methods.Day_02_thread_methods;

public class Join {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Main Thread starts");
    Thread t1 = new Thread(()-> {
      try{
        Thread.sleep(5000);
      }catch (InterruptedException e){

      }
      System.out.println("Thread 0 starts");
    });
    t1.start();
    t1.join(); // let the t1 thread first complete its execution
    // t1.join(2000); // wait max 2 sec to complete t1 otherwise starts your execution
    System.out.println("Main Thread ends");
  }
}

// join()
//------------------------------------------
// Main thread --> WAITING
// t1 thread  -->  RUNNABLE  --> TERMINATED
// Main thread  -->  WAITING  --> RUNNABLE  -->TERMINATED


// join(2000) : wait max 2 sec to complete t1 otherwise starts your execution
//------------------------------------------
// Main thread --> TIMED_WAITING
// t1 thread  -->  RUNNABLE  --> TERMINATED
// Main thread  -->  TIMED_WAITING  --> RUNNABLE  -->TERMINATED