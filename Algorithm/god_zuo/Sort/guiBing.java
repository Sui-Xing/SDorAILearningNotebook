package Sort;

public class guiBing {

    public static void main(String[] args) {
        int arr[]={5,3,6,2,9};
        process(arr,0,4);
        for(int a:arr){
            System.out.println(a);
        }
    }

    public static void process(int[] arr,int L,int R){
        // 注意终止条件
        if(L==R){
            return;
        }
        int mid = L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,R,mid);
    }

    public static void merge(int[] arr,int L ,int R,int M){
        int[] help=new int[R-L+1];
        int pointL=L;
        int pointR=M+1;
        int pointH=0;
        while( pointL<=M && pointR<=R  ){
            // 注意是小于等于
            help[pointH++]=arr[pointL]<=arr[pointR]?arr[pointL++]:arr[pointR++];
        }
        while(pointL<=M){
            help[pointH++]=arr[pointL++];
        }
        while (pointR<=R){
            help[pointH++]=arr[pointR++];
        }
        for(int i=0;i<R-L+1;i++){
            arr[L+i]=help[i];
        }

    }
}
