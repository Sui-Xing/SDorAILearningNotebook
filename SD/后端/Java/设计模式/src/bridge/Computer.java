package bridge;
// 不使用接口，是因为在Computer类中，需要引入商标，使用组合，进行桥接
public abstract class Computer {
    // 这里使用protected类型，确保其继承类能使用brand
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }
    public void info(){
        brand.info();
    }
}
