package factory.abstract_2;

public class huaweiIRouter implements IRouterProduct{
    @Override
    public void open() {
        System.out.println("华为路由器打开");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }

    @Override
    public void openWifi() {
        System.out.println("华为路由器打开无线网");
    }

    @Override
    public void shutDown() {
        System.out.println("华为路由器关机");
    }
}
