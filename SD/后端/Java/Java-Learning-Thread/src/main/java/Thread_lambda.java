public class Thread_lambda {
    public static void main(String[] args) {
        lambda l=(int a)->{
            System.out.println("start"+a);
        };

        l.lambdaTest(1);
    }
}
interface lambda{
    public void lambdaTest(int a);

}