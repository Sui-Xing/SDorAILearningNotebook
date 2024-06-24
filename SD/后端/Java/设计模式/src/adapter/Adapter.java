package adapter;




// 真正的适配器~，需要连接USB，连接网线

// 方法一：继承（类适配器）
/*public class Adapter extends Adaptee implements NetToUSB  {

    @Override
    public void handleRequest() {
        super.request();
    }
}*/

// 方法二：组合（对象适配器）
public class Adapter implements NetToUSB  {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }
}