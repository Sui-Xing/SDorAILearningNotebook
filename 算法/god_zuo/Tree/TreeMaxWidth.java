package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

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




        Queue<Tree> q=new LinkedList<Tree>();
        HashMap<Tree, Integer> nodeLeveMap = new HashMap<Tree, Integer>();
        q.offer(head);
        nodeLeveMap.put(head,1);


        int curLeve=1;
        int maxWidth=-1;
        int curNodeNum=0;
        int curNodeLeve=0;
        while(!q.isEmpty()){
            Tree curTree=q.poll();

            curNodeLeve=nodeLeveMap.get(curTree);
            if(curNodeLeve==curLeve){

                curNodeNum++;

            }else {
                System.out.printf("第%d层宽度为%d \n",curLeve,curNodeNum);
                curLeve++;

                maxWidth=Math.max(maxWidth,curNodeNum);
                curNodeNum=1;
            }
            if(curTree.right!=null){
                q.offer(curTree.right);
                nodeLeveMap.put(curTree.right,curLeve+1);
            }
            if(curTree.left!=null){
                q.offer(curTree.left);
                nodeLeveMap.put(curTree.left,curLeve+1);
            }
        }
        System.out.println("该树的最大宽度为"+(maxWidth));
    }


}
