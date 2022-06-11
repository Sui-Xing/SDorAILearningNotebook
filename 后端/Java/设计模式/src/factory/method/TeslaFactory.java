package factory.method;

public class TeslaFactory implements CarFactory {

    public Car getCar() {
        return new Tesla();
    }
}
