package Sort;

public class kuaiPai {
    public static void main(String[] args) {
        int[] arr={5,3,1,7,3,9};
        quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr,int L,int R){
        if(L>=R)return;
        int numIdx=(int) (Math.random()*(R-L+1));
        swap(arr,L+numIdx,R);
        int[] p = partition(arr,L-1,R+1);
        quickSort(arr,L,p[0]);
        quickSort(arr,p[1],R);

    }

    // 返回左区域的右边界，以及右区域的左边界
    public static int[] partition(int[] arr,int L,int R){
        int num=arr[R-1];
        int point=L+1;
        int pointL=L;
        int pointR=R;
        while(point<pointR){
            if(arr[point]<num){
                swap(arr,++pointL,point++);
            }
            else if(arr[point]==num){
                point++;
            }
            else if(arr[point]>num){
                swap(arr,--pointR,point);
            }
        }
        int[] p={pointL,pointR};
        return p;

    }

    public static void swap(int[] arr,int L,int R){
        int temp=arr[L];
        arr[L]=arr[R];
        arr[R]=temp;
    }
}
