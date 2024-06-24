package Tree;

import java.util.Stack;

public class treeTraversal {
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

        // 打印二叉树
        btp.print(head);

        // 输出前序遍历结果
        preorderTraversal(head);


    }
    // =============================
    //         非递归的方法
    // =============================


    // 前序遍历用一个栈按照  中 右 左 的顺讯进栈
    public static void preorderTraversal(BinaryTreeNode head){
        Stack<BinaryTreeNode> stk=new Stack<BinaryTreeNode>();
        stk.push(head);
        while(!stk.isEmpty()){
            BinaryTreeNode curNode=stk.pop();
            BinaryTreeNode right=curNode.getRight();
            BinaryTreeNode left=curNode.getLeft();

            System.out.println(curNode.getValue());

            if(right!=null){
                stk.push(right);
            }
            if(left!=null){
                stk.push(left);
            }

        }
    }


    // 前序遍历用一个栈按照  中 右 左 的顺讯进栈
    public static void postorderTraversal(BinaryTreeNode head){
        Stack<BinaryTreeNode> stk=new Stack<BinaryTreeNode>();
        stk.push(head);
        while(!stk.isEmpty()){
            BinaryTreeNode curNode=stk.pop();
            BinaryTreeNode right=curNode.getRight();
            BinaryTreeNode left=curNode.getLeft();

            System.out.println(curNode.getValue());

            if(right!=null){
                stk.push(right);
            }
            if(left!=null){
                stk.push(left);
            }

        }
    }
}
