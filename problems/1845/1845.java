import java.util.*;

class SeatManager {
  PriorityQueue<Integer> seats;

  public SeatManager(int n) {
    seats = new PriorityQueue<>();

    for (int i = 1; i <= n; i++) {
      seats.offer(i);
    }
  }

  public int reserve() {
    return seats.poll();
  }

  public void unreserve(int seatNumber) {
    seats.offer(seatNumber);
  }
}
