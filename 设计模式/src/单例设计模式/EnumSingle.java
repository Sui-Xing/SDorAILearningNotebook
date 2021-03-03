package 单例设计模式;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;

    }



}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        EnumSingle instance1=EnumSingle.INSTANCE;
        // EnumSingle instance2=EnumSingle.INSTANCE;
        System.out.println(instance1);
        // System.out.println(instance2);

        //java欺骗我们EnumSingle的构造方法为无餐
        //用jad反编译EnumSingle得到的构造方法为有参构造，参数为String与int
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle  instance2= declaredConstructor.newInstance();

        System.out.println(instance2);
    }
}