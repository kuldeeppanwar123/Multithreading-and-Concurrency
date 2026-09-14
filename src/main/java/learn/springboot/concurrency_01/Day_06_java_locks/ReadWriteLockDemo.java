package learn.springboot.concurrency_01.Day_06_java_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Reader-Writer Problem
public class ReadWriteLockDemo {

  public static void main(String[] args) {

    UserCache userCache = new UserCache();

    Thread reader1 = new Thread(() -> userCache.getUsername(), "reader1");
    Thread reader2 = new Thread(() -> userCache.getUsername(), "reader2");

    Thread writer1 = new Thread(() -> userCache.setUsername("John"), "writer1");
    Thread writer2 = new Thread(() -> userCache.setUsername("luther"), "writer2");

    reader1.start();
    reader2.start();
    writer1.start();
    writer2.start();
  }
}

class UserCache {

  private String username = "Kuldeep";

  private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

  private final Lock readLock = rwLock.readLock();
  private final Lock writeLock = rwLock.writeLock();

  public String getUsername() {
    readLock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " entered");
      Thread.sleep(1000);
      return username;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return username;
    } finally {
      System.out.println(Thread.currentThread().getName() + " exited");
      readLock.unlock();
    }
  }

  public void setUsername(String username)  {
    writeLock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " entered");
      Thread.sleep(1000);
      this.username = username;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      System.out.println(Thread.currentThread().getName() + " exited");
      writeLock.unlock();
    }
  }
}

// Reader => shared lock
// Writer => exclusive lock