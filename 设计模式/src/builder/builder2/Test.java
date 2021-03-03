package builder.builder2;


public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker();
        // 链式编程，这样就能实现自定义建造
        Product product = worker.buildA("全家桶").buildB("雪碧")
                .getProduct();
        System.out.println(product.toString());

    }
}
