package Tree;

import Tree.Tree;

public class searchTree {
    public static void main(String[] args) {

        Tree head=new Tree(6);
        Tree t1=new Tree(5);
        Tree t2=new Tree(4);
        Tree t3=new Tree(3);
        Tree t4=new Tree(7);
        Tree t5=new Tree(9);
        head.left=t1;
        head.right=t4;
        t1.left=t5;

        System.out.println("该二叉树是否为二叉搜索树："+isBst(head));


    }
    public static int preValue=Integer.MIN_VALUE;
    public static boolean isBst(Tree head){
        if(head==null){
            return true;
        }
        boolean isLeftBst=isBst(head.left);
        if(!isLeftBst){
            return false;
        }
        if(head.val<=preValue){
            return false;
        }else{
            preValue=head.val;
        }
        return isBst(head.right);
    }

}
