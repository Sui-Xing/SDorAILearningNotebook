package builder.builder2;


public abstract class Builder {

    // 注意这里的返回值是Builder，而是void，方便链式编程
    public abstract Builder buildA(String msg);  //汉堡
    public abstract Builder buildB(String msg);  //薯条
    public abstract Builder buildC(String msg);  //可乐
    public abstract Builder buildD(String msg);  //鸡肉卷

    public abstract Product getProduct();

}
