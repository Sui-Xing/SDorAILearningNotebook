public class duiPai {
    public static void main(String[] args) {
        int[] arr={3,8,6,5,9,4,6,7,20,1};
        heapSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void heapSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize=arr.length-1;
        while(heapSize>0){
            swap(arr,0,heapSize--);
            heapify(arr,heapSize);
        }
    }

    public static void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public static void heapify(int[] arr ,int heapSize){


        int point=0;
        int larger=0;
        while((point*2+1)<=heapSize){
            larger=point*2+2<=heapSize && arr[point*2+1]<arr[point*2+2]?point*2+2:point*2+1;
            larger=arr[point]>arr[larger]?point:larger;
            if(larger==point){
                break;
            }
            swap(arr,point,larger);
            point=larger;
        }



    }
    public static void swap(int[] arr,int L,int R){
        int temp=arr[L];
        arr[L]=arr[R];
        arr[R]=temp;
    }
}
