# **一、 Java面向对象有哪些特征，如何应用**

面向对象编程是利用类和对象编程的一种思想。

面向对象的三大特征封装，继承，多态。封装

- 封装说明一个类行为和属性与其他类的关系，低耦合，高内聚
- 继承是父类和子类的关系
- 多态说的是类与类的关系

多态：父类引用指向子类对象。

# 二、 ArrayList和LinkedList有什么区别

ArrayList和LinkedList都实现了List接口，他们有以下的不同点：

| ArrayList                                  | LinkedList                                                       |
| ------------------------------------------ | ---------------------------------------------------------------- |
| 是基于索引的数据接口，它的底层是数组。它可以以O(1)时间复杂度对元素进行随机访问。 | 是以元素列表的形式存储它的数据，每一个元素都和它的前一个和后一个元素链接在一起，在这种情况下，查找某个元素的时间复杂度是O(n) |
|                                            | 插入，添加，删除操作速度更快更占内存                                               |

# 三、 高并发中的集合有哪些问题

**第一代线程安全集合类**

Vector、Hashtable

是怎么保证线程安排的： 使用synchronized修饰方法*

缺点：效率低下

**第二代线程非安全集合类**

ArrayList、HashMap

线程不安全，但是性能好，用来替代Vector、Hashtable

使用ArrayList、HashMap，需要线程安全怎么办呢？

使用 `Collections.*synchronizedList*(list); Collections.*synchronizedMap*(m);`

底层使用synchronized代码块锁 虽然也是锁住了所有的代码，但是锁在方法里边，并所在方法外边性能可以理解为稍有提高吧。毕竟进方法本身就要分配资源的

**第三代线程安全集合类**

在大量并发情况下如何提高集合的效率和安全呢？

java.util.concurrent.*

ConcurrentHashMap：

CopyOnWriteArrayList ：

CopyOnWriteArraySet： 注意 不是CopyOnWriteHashSet*

底层大都采用Lock锁（1.8的ConcurrentHashMap不使用Lock锁），保证安全的同时，性能也很高。

## ConcurrentHashMap

### jdk7:

数据结构：ReentrantLock+Segment+HashEntry

分段锁

根据key定位segment段，锁定一个段，其他segment不受影响，锁的粒度更小

并发度就位segment的个数。

数组扩容只会操作一个segment，不会影响到其他的segment，其他segment可以正常访问

元素查询：两次hash，第一次hash定位到segment，第二次hash定位到元素所在的链表头部。

get()方法无需枷锁，volatile保证

segment继承自ReentrantLock

### jdk8:

数据结构：synchronized+CAS+Node+红黑树

Node的val和next都用volatile修饰，保证可见性

查找、替换、赋值操作都使用CAS，效率更高（CAS是乐观锁）

锁：锁链表的head节点，不影响其他元素的读写，锁的粒度更细，效率更高，扩容时会阻塞所有的读写操作、并发扩容

读操作无所：

Node的val和next使用volatile修饰，读写线程对该变量互相可见

数组用volatile修饰，保证扩容时被读线程感知。

# 四、JDK1.8的新特性有哪些

### 1. 接口的默认方法

Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法

### 2. Lambda 表达式

### 3. 函数式接口

### 4. 方法与构造函数引用

### 5. Lambda 作用域

### 6. 访问局部变量

### 7. 访问对象字段与静态变量

### 8. 访问接口的默认方法

### 9. Date API

### 10. Annotation 注解(多重注解)

# 五、 Java中重写和重载有哪些区别

# 六、接口和抽象类有哪些区别

不同：

抽象类：

1.抽象类中可以定义构造器

2.可以有抽象方法和具体方法

3.接口中的成员全都是 public 的

4.抽象类中可以定义成员变量

5.有抽象方法的类必须被声明为抽象类，而抽象类未必要有抽象方法

6.抽象类中可以包含静态方法

7.一个类只能继承一个抽象类

接口：

1.接口中不能定义构造器

2.方法全部都是抽象方法

3.抽象类中的成员可以是 private、默认、protected、public

4.接口中定义的成员变量实际上都是常量

5.接口中不能有静态方法

6.一个类可以实现多个接口  

相同：

1.不能够实例化

2.可以将抽象类和接口类型作为引用类型

3.一个类如果继承了某个抽象类或者实现了某个接口都需要对其中的抽象方法全部进行实现，否则该类仍然需要被声明为抽象类

抽象类一般是指一个具体概念（如动物）

接口一般是指一类事物具有的共同特征（会飞的）

# HashMap原理

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418114738.png)

hashcode1与hashcode2在oldthreshold大小中 hash值是一样的，因此在一跳链表中

但 在newThr中，由于两个hashcode的第5位不同，因此&上newThr的hash也不同，因此在旧表中一条链上的两个值在新表中分别会在两个链上，这两个链的hash差了一个threshold

即 000**1** 0101-000**0** 0101=0001 0000
