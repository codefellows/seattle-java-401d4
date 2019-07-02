/**
 * BinaryTree
 */
public class BinaryTree {

  private String value;
  private BinaryTree left;
  private BinaryTree right;

  public BinaryTree(String value) {
    this.value = value;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(this.value);

    if (this.left != null) {
      s.append(this.left.toString());
    }
    if (this.right != null) {
      s.append(this.right.toString());
    }

    return s.toString();
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public BinaryTree getLeft() {
    return left;
  }

  public void setLeft(BinaryTree left) {
    this.left = left;
  }

  public BinaryTree getRight() {
    return right;
  }

  public void setRight(BinaryTree right) {
    this.right = right;
  }
}
