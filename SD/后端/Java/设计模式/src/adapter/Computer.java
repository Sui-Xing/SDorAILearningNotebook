package adapter;


// 客户端类：向上网，插不上网线~
public class Computer {

    // 我们的电脑需要转接器才能连接电脑
    public void net(NetToUSB netToUSB){
        // 上网的具体实现~，找一个转接头
        netToUSB.handleRequest();
    }


    public static void main(String[] args) {
        // 电脑，适配器，网线

        // 方法一：继承（类适配器）
        /*Computer computer = new Computer();
        Adapter adapter = new Adapter();
        Adaptee adaptee = new Adaptee();

        computer.net(adapter);*/

        // 方法二：组合（对象适配器）
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);

        computer.net(adapter);

    }
}
