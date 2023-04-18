<!--ts-->
<!--te-->
# JVM基础
---
# 堆和栈

**JAVA在程序运行时，在内存中划分5片空间进行数据的存储。分别是：1：寄存器。2：本地方法区。3：方法区。4：栈。5：堆。**

基本，栈stack和堆heap这两个概念很重要，不了解清楚，后面就不用学了。

以下是这几天栈和堆的学习记录和心得。得些记录下来。以后有学到新的，会慢慢补充。

**一、先说一下最基本的要点**

基本数据类型、局部变量都是存放在栈内存中的，用完就消失。  
new创建的实例化对象及数组，是存放在堆内存中的，用完之后靠垃圾回收机制不定期自动消除。

**二、先明确以上两点，以下示例就比较好理解了**

**示例1**

main()  
int x=1;  
show ()  
int x=2

主函数main()中定义变量int x=1，show()函数中定义变量int x=1。最后show()函数执行完毕。

以上程序执行步骤：

第1步——main()函数是程序入口，JVM先执行，在栈内存中开辟一个空间，存放int类型变量x，同时附值1。  
第2步——JVM执行show()函数，在栈内存中又开辟一个新的空间，存放int类型变量x，同时附值2。  
此时main空间与show空间并存，同时运行，互不影响。  
第3步——show()执行完毕，变量x立即释放，空间消失。但是main()函数空间仍存在，main中的变量x仍然存在，不受影响。

示图如下：

![](https://cdn.nlark.com/yuque/0/2022/jpeg/25474118/1660736752688-7e96a1ac-d278-4944-a6c5-a73a5f037d43.jpeg)

# **示例2**

main()  
int[] x=new int[3];  
x[0]=20

主函数main()中定义数组x，元素类型int，元素个数3。

以上程序执行步骤  
第1步——执行int[] x=new int[3];  
隐藏以下几分支  
JVM执行main()函数，在栈内存中开辟一个空间，存放x变量（x变量是局部变量）。  
同时，在堆内存中也开辟一个空间，存放new int[3]数组，堆内存会自动内存首地址值，如0x0045。  
数组在栈内存中的地址值，会附给x，这样x也有地址值。所以，x就指向（引用）了这个数组。此时，所有元素均未附值，但都有默认初始化值0。

第2步——执行x[0]=20  
即在堆内存中将20附给[0]这个数组元素。这样，数组的三个元素值分别为20,0,0

示图如下：

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120013.png)

**示例3**  
main()  
int[] x=new int[3];  
x[0]=20  
x=null;

以上步骤执行步骤  
第1、2步——与示例2完全一样，略。

第3步——执行x=null;  
null表示空值，即x的引用数组内存地址0x0045被删除了，则不再指向栈内存中的数组。此时，堆中的数组不再被x使用了，即被视为垃圾，JVM会启动垃圾回收机制，不定时自动删除。

示图如下

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120025.png)

**示例4**  
main()  
int[] x=new int[3];  
int[] y=x;  
y[1]=100  
x=null;

以上步骤执行步骤

第1步——与示例2第1步一致，略。  
第2步——执行int[] y=x，  
在栈内存定义了新的数组变量内存y，同时将x的值0x0045附给了y。所以，y也指向了堆内存中的同一个数组。  
第3步——执行y[1]=100  
即在堆内存中将20附给[0]这个数组元素。这样，数组的三个元素值分别为0,100,0  
第4步——执行x=null  
则变量x不再指向栈内存中的数组了。但是，变量y仍然指向，所以数组不消失。

示图如下

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120040.png)

**示例5**

Car c=new Car;  
c.color="blue";  
Car c1=new Car;  
c1.num=5;

虽然是个对象都引用new Car，但是是两个不同的对象。每一次new，都产生不同的实体

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120057.png)

**示例6**

Car c=new Car;  
c.num=5;  
Car c1=c;  
c1.color="green";  
c.run();

Car c1=c，这句话相当于将对象复制一份出来，两个对象的内存地址值一样。所以指向同一个实体，对c1的属性修改，相当于c的属性也改了。

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120111.png)

**三、****栈和****堆的特点**

**栈：**

- 函数中定义的基本类型变量，对象的引用变量都在函数的栈内存中分配。
- 栈内存特点，数数据一执行完毕，变量会立即释放，节约内存空间。
- 栈内存中的数据，没有默认初始化值，需要手动设置。  

**堆：**

- 堆内存用来存放new创建的对象和数组。
- 堆内存中所有的实体都有内存地址值。
- 堆内存中的实体是用来封装数据的，这些数据都有默认初始化值。
- 堆内存中的实体不再被指向时，JVM启动垃圾回收机制，自动清除，这也是JAVA优于C++的表现之一（C++中需要程序员手动清除）。

注：

**什么是局部变量：**定义在函数中的变量、定义在函数中的参数上的变量、定义在for循环内部的变量

# 美团追魂七连问

关于 `Object o =new Object()`

1. 请解释一下对象的创建过程（半初始化问题）
2. 加问DCL要不要加volatile问题（指令重排）
3. 对象在内存中的存储布局（对象与数组的存储不同）
4. 对象头具体包括什么（markword classpointer synchronized锁信息)
5. 对象怎么定位（直接、间接）
6. 对象怎么分配（栈上-线程本地-Eden-Old）
7. `Object o =new Object()`在内存中占用了多少字节
8. 新问题：为什么hotspot不适用C++对象来代表java对象

## 3. 对象在内存中的存储布局（对象与数组的存储不同）

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120128.png)

- markword 占8个字节：

- 锁信息，

- hashcode（），

- GC的信息：颜色，三色标记

- classpointer类型指针占4个字节：指向该对象属于哪个类

- instance data实例数据：成员变量

- padding对齐：将对象的大小补齐到8的倍数  

## 4. 对象头具体包括什么（markword classpointer synchronized锁信息)

- markword 占8个字节：

- 锁信息，

- hashcode（），

- GC的信息：颜色，三色标记

## 5. 对象怎么定位

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120139.png)

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120147.png)

1. 直接定位：

2. 优点

3. 直接访问

4. 缺点

5. GC需要移动对象，效率低

6. 句柄方式：

7. 优点

8. 对象更小

9. 垃圾回收效率更高

10. 缺点

11. 定位需要两次访问

垃圾回收，分带或者分区模型，对象会从内存中一个位置移动到另一个位置

## 6. 对象怎么分配

jdk1.8 垃圾回收 分区模型

会分成年轻代和老年代

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120203.png)

老年代是经历了很多次垃圾回收都没有回收掉的进入老年代。

- 标记清除：标记垃圾的位置，清空垃圾所在位置的内存

- 缺点：内存会产生碎片

- 复制：内存分成两块，把活着的复制到另一块，把当前这块直接全部清除，就实现了垃圾回收。

- 优点：当对象中需要保留的对象占极少数时，回收效率很高

- 缺点：浪费空间

- ⭐分取模型结合上述两种：

- **新生代用于存储新建或者较新的对象，新建对象过程中最终只会保留极少数，因此在新生代使用复制的方法。**新建对象存在伊甸区，如果经过一次垃圾回收，一个对象还活着，他会复制进入survivor1（**survivor1很小，因为在新生代中幸存的对象总数较少**），再经历一次垃圾回收，该对象如果还活着，他会复制到survivor2，然后清除伊甸区和survivor2，之后如果还活着，会复制到survivor1，然后清除伊甸区和survivor1。

**栈**是在一个栈数据结构中，较小256k

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120224.png)

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120236.png)

是否进栈：

- 逃逸分析：是否被别的对象或者方法引用，如果被他在栈中下一层的对象引用，当前对象或方法弹出，会影响下一层的对象或方法
- 标量替换：在 JIT 阶段，如果经过逃逸分析，发现一个对象不会被外界访问的话，那么经过 JIT 优化，就会把这个对象拆解成若干个其中包含的若干个成员变量来代替。这个过程就是标量替换。

对象如果足够大，也不会进栈，会直接进老年代（JVM调优中会调整多大算大）  

如果不大不小会进入伊甸园区，在这之前会进行线程本地分配缓存 thread local allocation buffer。如果好多个线程进入伊甸园区，会优先进入一个专门给自己分配的一个的空间，判断自己 的空间满了再进入公共空间。

## 1. 对象的创建过程

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120254.png)



**对象创建分3步**

1. **new：**是分配空间

dup：。。。。。。（复杂）

2. **invokespecial：** 调用构造方法
3. **astore_1：**建立变量与对象空间的关联
- C++：中new一个对象，成员变量m一开始他是遗留值，即上次使用该地址空间的值。
- Java：new的过程中成员变量 首先 全部赋值为默认值，因此他更为安全

当new对象的过程中执行到invokespecial，成员变量m才从默认值0被赋值为8

## 思考：程序真的是按照“顺序”执行的吗

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120312.png)

- 由于CPU寄存器速度比内存快很多因此为提高执行效率，CPU指令可能会乱序执行。

**单线程中程序什么时候可以乱序？**能保持最终一致性。（即程序运行后的结果一样，左边不能保证最终一致性）

### this溢出问题

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120318.png)

对象构建了一半，当新建对象还没执行到invokespecial时线程启动调用this.num，num=0；而不是8。

## 2. 加问DCL要不要加volatile问题（指令重排）

要加，必须要加

volatile能禁止指令重排序

单例模式：

[设计模式](https://www.cnblogs.com/AlwaysSui/p/14764895.html)

Double Check Lock

//懒汉式单例
public class LazyMan{
    private LazyMan(){

    }
    
    private volatile static LazyMan lazyMan;
    
    //双重检测模式的懒汉式单例 ，即DCL懒汉式
    public static LazyMan getInstance(){
        // 这一层判断不能删除，因为如果删除该判断，
        // 当同时大量线程执行该方法，那么每个线程都要上完锁才能得到对象
        // 效率极低
        if(lazyMan==null){
            synchronized(LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();//不是一个原子性操作
                    /**
                    1.分配内存空间
                    2.执行构造方法，初始化对象
                    3.把这个对象指向这个空间
    
                    123
                    132 A
                        B    此时lazyMan还没有完成构造
                    **/
    
                }
            }
        }
    
        return lazyMan;
    }
    
    //多线程下不安全
    //多线程并发
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            new Thread(()->{
                lazyMan.getInstance();
            }).start();
        }
    }

}

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418120329.png)

**synchronized中会不会发生指令重排？**

lazyMan都是指向同一个内存空间

**为什么第二个线程能拿到中间过程的值？**

**因为第二个线程进来判断**lazyMan==null是在**synchronized**外面的，此时第一个线程已经给instance赋值，判断为false，直接返回中间过程的值。
