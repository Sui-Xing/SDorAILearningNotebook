import Tree.BinaryTreeNode;
import Tree.BinaryTreePrinter;

public class test {
    public static void main(String[] args) {
        BinaryTreeNode head=new BinaryTreeNode(6);

        BinaryTreeNode t1=new BinaryTreeNode(5);
        BinaryTreeNode t2=new BinaryTreeNode(4);
        BinaryTreeNode t3=new BinaryTreeNode(3);
        BinaryTreeNode t4=new BinaryTreeNode(7);
        BinaryTreeNode t5=new BinaryTreeNode(9);
        head.setLeft(t1);
        head.setRight(t4);
        t1.setLeft(t5);
        t5.setLeft(t2);
        t4.setLeft(t3);

        BinaryTreePrinter btp = new BinaryTreePrinter();
        btp.print(head);



    }


}
class PrintBinaryTree {
    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        printTree(node.right, depth + 1);
        if (depth != 0) {
            for (int i = 0; i < depth - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + node.val);
        } else {
            System.out.println(node.val);
        }
        printTree(node.left, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        printTree(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
