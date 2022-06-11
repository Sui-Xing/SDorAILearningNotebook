public class joinTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("插队者==>"+i);
        }
    }

    public static void main(String[] args) {
        joinTest jt=new joinTest();
        Thread thread = new Thread(jt);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程-->"+i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(i==10){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
