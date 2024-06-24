package builder.builder1;

public class Director {


    public Product getProduct(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();

    }
}
