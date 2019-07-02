/**
 * Runner
 */
public class Runner {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree("Does it move?");

    BinaryTree l = new BinaryTree("Yes, should it?");
    BinaryTree r = new BinaryTree("No, should it?");

    BinaryTree ll = new BinaryTree("Yes: No problem");
    BinaryTree lr = new BinaryTree("No: Duct Tape");
    BinaryTree rl = new BinaryTree("Yes: WD40!");
    BinaryTree rr = new BinaryTree("No: No problem");

    l.setLeft(ll);
    l.setLeft(lr);

    r.setLeft(rl);
    r.setLeft(rr);

    tree.setLeft(l);
    tree.setRight(r);

    System.out.println(tree.toString());
  }
}
