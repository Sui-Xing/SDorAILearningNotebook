package factory.simple;

public class Consumer {
    public static void main(String[] args) {
        // 接口，所有实现类
        Car car=new WuLing();
        Car car2=new Tesla();
        car.name();
        car2.name();

        // Car car = CarFactory.getCar("五菱");
        // Car car2 = CarFactory.getCar("特斯拉");
        // car.name();
        // car2.name();
    }
}
