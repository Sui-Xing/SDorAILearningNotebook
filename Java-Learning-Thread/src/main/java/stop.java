public class stop implements Runnable {
    static int num=0;
    boolean flag=true;
    @Override
    public void run() {
        while (num<1000){
            System.out.println(Thread.currentThread().getName()+"thread==>"+num++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        stop s=new stop();
        while (s.num>200){
            s.stop();
        }
        Thread thread=new Thread(s,"线程1");
        Thread thread2=new Thread(s,"线程2");
        thread.start();
        thread2.start();




    }
}
