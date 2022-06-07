package factory.method;

public class  DaZhongFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new DaZhong();
    }
}
