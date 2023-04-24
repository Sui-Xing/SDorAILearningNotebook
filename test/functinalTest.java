
public class functinalTest {
    public static void main(String[] args) {
        MyFunctionalInterface myFunction = (a, b) -> a + b;
        int result = myFunction.doSomething(10, 20);
        System.out.println(result); // 输出 30
    }
}
