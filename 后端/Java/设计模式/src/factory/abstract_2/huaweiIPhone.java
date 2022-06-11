package factory.abstract_2;

public class huaweiIPhone implements IPhoneProduct {
    @Override
    public void open() {
        System.out.println("华为手机开机");
    }

    @Override
    public void callUp() {
        System.out.println("华为手机打电话");

    }

    @Override
    public void sendSMS() {
        System.out.println("华为手机发短信");

    }

    @Override
    public void shutDown() {
        System.out.println("华为手机关机");

    }
}
