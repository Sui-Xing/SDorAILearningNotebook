package factory.abstract_2;

public class xiaomiIRouter implements IRouterProduct{
    @Override
    public void open() {
        System.out.println("小米路由器打开");
    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置");
    }

    @Override
    public void openWifi() {
        System.out.println("小米路由器打开无线网");
    }

    @Override
    public void shutDown() {
        System.out.println("小米路由器关机");
    }
}
