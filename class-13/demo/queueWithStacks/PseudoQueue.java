public class PseudoQueue {
  private Stack enqueueStack;
  private Stack dequeueStack;

  public PseudoQueue() {
    this.enqueueStack = new Stack();
    this.dequeueStack = new Stack();
  }

  public void enqueue(int value) {
    this.enqueueStack.push(value);
  }

  public int dequeue() {
    if (this.dequeueStack.isEmpty()) {
      this.flip();
    }
    return this.dequeueStack.pop();
  }

  public int peek() {
    if (this.dequeueStack.isEmpty()) {
      this.flip();
    }
    return this.dequeueStack.peek();
  }

  private void flip() {
    while (!this.enqueueStack.isEmpty()) {
      this.dequeueStack.push(this.enqueueStack.pop());
    }
    // if the dequeue stack is empty now, we're in trouble
    if (this.dequeueStack.isEmpty()) {
      throw new IllegalStateException("Attempting to operate on empty queue");
    }
  }
}