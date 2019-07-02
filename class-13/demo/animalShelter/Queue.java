public class Queue<T> {
  private Node<T> front;
  private Node<T> back;

  public Queue() {
    this.front = null;
    this.back = null;
  }

  public void enqueue(T value) {
    Node<T> newNode = new Node<>(value, this.front);
    this.front = newNode;
    if (this.back == null) {
      this.back = newNode;
    }
  }

  public T peek() {
    if (this.front == null) {
      throw new IllegalStateException("Cannot peek an empty queue");
    } else {
      return this.front.value;
    }
  }

  public T dequeue() {
    if (this.front == null) {
      throw new IllegalStateException("Cannot dequeue on an empty queue");
    } else {
      T answer = this.front.value;
      this.front = this.front.next;
      if (this.front == null) {
        this.back = null;
      }
      return answer;
    }
  }
}

class Node<T> {
  protected T value;
  protected Node<T> next;

  public Node() {}

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }
}