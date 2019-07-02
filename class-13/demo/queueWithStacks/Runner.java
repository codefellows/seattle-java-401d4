public class Runner {
  public static void main(String[] args) {
    PseudoQueue pq = new PseudoQueue();
    pq.enqueue(0);
    pq.enqueue(1);
    pq.enqueue(2);
    System.out.println("dequeue should give 0: " + pq.dequeue());
    System.out.println("dequeue should give 1: " + pq.dequeue());
    pq.enqueue(3);
    System.out.println("dequeue should give 2: " + pq.dequeue());
    pq.enqueue(4);
    System.out.println("peek should give 3: " + pq.peek());
    pq.enqueue(5);
    System.out.println("dequeue should give 3: " + pq.dequeue());
    System.out.println("dequeue should give 4: " + pq.dequeue());
    System.out.println("dequeue should give 5: " + pq.dequeue());
    System.out.println("Going to try to dequeue, should break");
    pq.dequeue();
    System.out.println("IT DIDN'T BREAK YOU DID IT WRONG");
  }
}