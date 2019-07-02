import java.util.ArrayList;

public class Tree<E> {
  Node<E> root;

  public Tree() {
    this.root = null;
  }

  public Tree(Node<E> root) {
    this.root = root;
  }

  public static void main(String[] args) {
    //     3
    //    / \
    //   2   6
    //  /
    // 7
    Node<Integer> node7 = new Node<>(7, null, null);
    Node<Integer> node2 = new Node<>(2, node7, null);
    
    Node<Integer> nodes = new Node<>(3,
      new Node(2, 
        new Node(7, null, null),
        null),
      new Node(6, null, null)
    );
    Tree<Integer> t = new Tree<>(nodes);
    System.out.println(t.inorder());
  }

  public ArrayList<E> inorder() {
    return inorder(this.root);
  }

  private ArrayList<E> inorder(Node<E> current) {
    // base case: current node is null
    if (current == null) {
      return new ArrayList<E>();
    } else {
      ArrayList<E> leftAns = inorder(current.left);
      ArrayList<E> rightAns = inorder(current.right);

      ArrayList<E> ans = new ArrayList<>();
      ans.add(current.value);
      ans.addAll(leftAns);
      ans.addAll(rightAns);
      return ans;
    }
  }

}

class Node<T> {
  T value;
  Node<T> left;
  Node<T> right;

  public Node() {
    this.value = null;
    this.left = null;
    this.right = null;
  }

  public Node(T value, Node<T> left, Node<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}