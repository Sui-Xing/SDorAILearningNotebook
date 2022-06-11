package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /*Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
            new Class<?>[] { Foo.class },
            handler);*/

    public Object getProxy(){
      return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质就是使用反射机制
        Object invoke = method.invoke(target, args);
        seeHouse();
        contract();
        fee();
        return invoke;
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void contract(){
        System.out.println("签合同");
    }

    public void fee(){
        System.out.println("中介收中介费");
    }
}
