public class qiuXiaoHe {
    public static void main(String[] args) {
        int arr[]={5,3,6,2,9};
        process(arr,0,4);
        for(int a:arr){
            System.out.println(a);
        }
    }

    public static int process(int[] arr,int L,int R){
        // 注意终止条件
        if(L==R){
            return 0;
        }
        int mid = L+((R-L)>>1);

        return process(arr,L,mid)+process(arr,mid+1,R)+merge(arr,L,R,mid);
    }

    public static int merge(int[] arr,int L ,int R,int M){
        int[] help=new int[R-L+1];
        int pointL=L;
        int pointR=M+1;
        int pointH=0;
        int res=0;
        while( pointL<=M && pointR<=R  ){
            // 关键修改点
            res=arr[pointL]<arr[pointR]?(R-pointR+1)*arr[pointL]:0;


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
        return res;
    }
}
