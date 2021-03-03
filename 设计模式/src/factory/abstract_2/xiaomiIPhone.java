package factory.abstract_2;

public class xiaomiIPhone implements IPhoneProduct {

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void callUp() {
        System.out.println("小米手机打电话");

    }

    @Override
    public void sendSMS() {
        System.out.println("小米手机发短信");

    }

    @Override
    public void shutDown() {
        System.out.println("小米手机关机");

    }
}
