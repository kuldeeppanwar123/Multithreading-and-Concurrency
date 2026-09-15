package learn.springboot.concurrency_01.Day_07_lock_free_concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
  public static void main(String[] args) {
    SeatBooking2 sb = new SeatBooking2();
    Thread t1 = new Thread(()-> System.out.println(sb.bookSeat("GS")));
    Thread t2 = new Thread(()-> System.out.println(sb.bookSeat("VK")));

    t1.start();
    t2.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {

    }
    System.out.println(sb.seat);
  }
}

class SeatBooking {
  String seat = new String("Available");

  public boolean bookSeat(String person) {
    if (seat.equals("Available")) {
      seat = new String(person);
      return true;
    }
    System.out.println("Seat is already booked by "+seat);
    return false;
  }
}

class SeatBooking2 {
  AtomicReference<String> seat = new AtomicReference<>("Available");

  public boolean bookSeat(String person) {
    String current = seat.get();

    if (current.equals("Available")==false) {
      return false;
    }
    return seat.compareAndSet("Available", person);
  }

}