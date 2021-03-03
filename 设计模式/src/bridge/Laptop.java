package bridge;


public class Laptop extends Computer{
    public Laptop(Brand brand) {
        super(brand);
    }
    public void info(){
        super.info();
        System.out.println("笔记本");
    }
}
