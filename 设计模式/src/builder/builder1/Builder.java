package builder.builder1;

public abstract class Builder {
    public abstract void buildA();  //地基
    public abstract void buildB();  //钢筋工程
    public abstract void buildC();  //铺电线
    public abstract void buildD();  //粉刷

    public abstract Product getProduct();

}
