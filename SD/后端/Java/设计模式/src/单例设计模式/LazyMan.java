package 单例设计模式;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//懒汉式单例
public class LazyMan{
    private static boolean qinjiang=false;
    private LazyMan(){
        synchronized (LazyMan.class){
            if(qinjiang==false){
                qinjiang=true;
            }else{
                throw new RuntimeException("使用反射破坏单例异常");
            }
        }
    }

    private volatile static LazyMan lazyMan;

    //双重检测模式的懒汉式单例 ，即DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized(LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();
                }
            }
        }

        return lazyMan;
    }


    //反射
    public static void main(String[] args) throws Exception {
        Field qinjiang_ = LazyMan.class.getDeclaredField("qinjiang");
        qinjiang_.setAccessible(true);

        // 单例设计模式.LazyMan instance = 单例设计模式.LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance=declaredConstructor.newInstance();

        qinjiang_.set(instance,false);

        LazyMan instance2=declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);

    }


}