package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class treePrint {
    Tree tree=null;
    public void treePrint(Tree tree){
        this.tree=tree;
    }

    public void printTree(){
        Tree head=tree;
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
