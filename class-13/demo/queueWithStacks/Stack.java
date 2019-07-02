public class Stack {
  private Node top;

  public Stack() {
    this.top = null;
  }

  public void push(int value) {
    this.top = new Node(value, this.top);
  }

  public int peek() {
    if (this.top == null) {
      throw new IllegalStateException("Cannot peek an empty stack");
    } else {
      return this.top.value;
    }
  }

  public int pop() {
    if (this.top == null) {
      throw new IllegalStateException("Cannot pop an empty stack");
    } else {
      int answer = this.top.value;
      this.top = this.top.next;
      return answer;
    }
  }

  public boolean isEmpty() {
    return this.top == null;
  }
}

class Node {
  protected int value;
  protected Node next;

  public Node() { }

  public Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }
}