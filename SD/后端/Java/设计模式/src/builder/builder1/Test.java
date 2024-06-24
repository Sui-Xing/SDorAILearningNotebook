package builder.builder1;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Director director = new Director();
        Product product = director.getProduct(worker);
        System.out.println(product);

    }
}
