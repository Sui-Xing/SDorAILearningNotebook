package dynamicproxy;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(host);
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        proxy.rent();

    }
}
