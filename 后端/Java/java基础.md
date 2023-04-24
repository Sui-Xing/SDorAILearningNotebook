# 一、 Java面向对象有哪些特征，如何应用

面向对象编程是利用类和对象编程的一种思想。

面向对象的三大特征封装，继承，多态。封装

- 封装说明一个类行为和属性与其他类的关系，低耦合，高内聚
- 继承是父类和子类的关系
- 多态说的是类与类的关系

多态：它是指在父类中定义的属性和方法被子类继承之后，可以具有不同的数据类型或表现出不同的行为，这使得同一个属性或方法在父类及其各个子类中具有不同的含义。

    

# 二、 ArrayList和LinkedList有什么区别

ArrayList和LinkedList都实现了List接口，他们有以下的不同点：

| ArrayList                                  | LinkedList                                                       |
| ------------------------------------------ | ---------------------------------------------------------------- |
| 是基于索引的数据接口，它的底层是数组。它可以以O(1)时间复杂度对元素进行随机访问。 | 是以元素列表的形式存储它的数据，每一个元素都和它的前一个和后一个元素链接在一起，在这种情况下，查找某个元素的时间复杂度是O(n) |
|                                            | 插入，添加，删除操作速度更快更占内存                                               |

&nbsp;

# 三、 高并发中的集合有哪些问题

**第一代线程安全集合类**

Vector、Hashtable

是怎么保证线程安排的： 使用synchronized修饰方法*

缺点：效率低下

&nbsp;

**第二代线程非安全集合类**

ArrayList、HashMap

线程不安全，但是性能好，用来替代Vector、Hashtable

使用ArrayList、HashMap，需要线程安全怎么办呢？

使用 `Collections.*synchronizedList*(list); Collections.*synchronizedMap*(m);`

底层使用synchronized代码块锁 虽然也是锁住了所有的代码，但是锁在方法里边，并所在方法外边性能可以理解为稍有提高吧。毕竟进方法本身就要分配资源的

&nbsp;

**第三代线程安全集合类**

在大量并发情况下如何提高集合的效率和安全呢？

**java.util.concurrent.***

1. **ConcurrentHashMap**：Concurrent  /kənˈkʌr.ənt/ 是并发的意思。

2. **CopyOnWriteArrayList** ：

3. **CopyOnWriteArraySet**： 注意 不是CopyOnWriteHashSet*

底层大都采用Lock锁（1.8的ConcurrentHashMap不使用Lock锁），保证安全的同时，性能也很高。

CopyOnWrite 是一种读写分离的策略，它通过在写操作时复制一份原数据，然后在新数据上进行写操作，从而避免了对原数据的修改，保证了读操作的线程安全性。具体来说，当要进行写操作时，CopyOnWrite 容器会先将原数据复制一份，然后在新数据上进行写操作，写操作完成后再将原数据替换为新数据。这样做的好处是，读操作可以无锁地进行，因为读操作不会对原数据进行修改。

CopyOnWrite 容器一般用于读多写少的场景，比如缓存、读取频繁但修改很少的数据等。在这些场景下，CopyOnWrite 容器可以提高读取性能，同时保证写操作的线程安全性。

&nbsp;

***

## 3.1 ConcurrentHashMap

### 3.1.1 JDK-7

- **ReentrantLock**是 Java 提供的一种可重入的互斥锁，它可以用来保护临界区，避免多个线程同时访问共享资源而导致的数据不一致或者死锁等问题。
  
  - ReentrantLock 与 synchronized 相比，有以下几个优点：
    
    - 可以实现公平锁和非公平锁：ReentrantLock 提供了构造方法可以指定锁是公平锁还是非公平锁，默认是非公平锁。
    
    - 可以中断等待锁的线程：当一个线程长时间等待锁时，可以通过调用该线程的 interrupt() 方法来中断等待，从而避免死锁。
    
    - 可以实现多个条件变量：ReentrantLock 提供了 Condition 接口，可以用来实现多个条件变量，从而使得不同的线程可以等待不同的条件。
    
    - 支持可重入性：同一个线程可以多次获取同一个 ReentrantLock 锁，从而避免了死锁的发生。

-  **Segment** 是 ConcurrentHashMap 中的一个重要概念，它是由 Doug Lea 在设计 ConcurrentHashMap 时引入的一种分段锁机制，用于提高 ConcurrentHashMap 的并发性能。
  
  - 在 ConcurrentHashMap 中，整个数据集被分成多个 Segment，segment继承自ReentrantLock，每个 Segment 内部维护一个 Hash 表，不同的线程在访问不同的 Segment 时，是不会发生锁竞争的。每个 Segment 内部的元素访问是通过 ReentrantLock 锁实现的，但是不同的 Segment 之间并没有共享的状态或资源，因此不同线程在访问不同 Segment 的时候，不会产生锁竞争和性能瓶颈。

-  **数据结构**
  
  - **ReentrantLock+Segment+HashEntry**
  
  - 根据key定位segment段，锁定一个段，其他segment不受影响，锁的粒度更小并发度就位segment的个数。数组扩容只会操作一个segment，不会影响到其他的segment，其他segment可以正常访问
  
  - 元素查询：两次hash，第一次hash定位到segment，第二次hash定位到元素所在的链表头部。



    

### 3.1.2 JDK-8

-  **volatile** 是一种关键字，用于修饰变量。当变量被 volatile 修饰时，保证了下面两个特性：
  
  - 可见性：当一个线程修改了一个 volatile 变量的值时，其他线程可以立即看到这个变量的最新值。这是由于 volatile 变量的值存储在主内存中，每个线程读取变量的值时都从主内存中读取，从而避免了缓存一致性的问题。
  
  - 禁止重排序：当一个线程对一个 volatile 变量进行写操作时，JVM 会保证该操作不会和其他指令重排序。这可以保证 volatile 变量的赋值操作是原子性的，从而避免了多线程环境下可能出现的线程安全问题。

- **CAS**（Compare and Swap）是一种基于原子操作的并发算法，用于实现无锁的线程安全编程。CAS 操作包括三个操作数：内存位置（V）、期望值（A）和新值（B）。
  
  - 当需要更新内存位置 V 的值时，CAS 会先比较内存位置 V 的当前值是否等于期望值 A，如果相等，则将内存位置 V 的值设置为新值 B，否则不进行任何操作。整个 CAS 操作是原子性的，因此能够保证线程安全。
  
  - 在 Java 中，CAS 操作通常是通过 java.util.concurrent.atomic 包中的 AtomicXXX 类来实现的，其中 XXX 可以是 Integer、Long、Boolean 等基本类型。这些类提供了一系列原子操作，包括 get、set、compareAndSet 等方法，可以保证在多线程环境下，对于同一个变量的操作是线程安全的。
  
  - 需要注意的是，虽然 CAS 操作可以实现无锁的线程安全编程，但是它也存在一些限制和缺陷。其中最主要的就是 ABA 问题，即当一个变量从 A 变为 B，再从 B 变回 A 时，CAS 操作可能会误判为没有发生变化，从而导致线程安全问题。为了解决 ABA 问题，Java 提供了 AtomicStampedReference 和 AtomicMarkableReference 等类，可以通过增加版本号或者标记位来解决该问题。    

-  **数据结构：synchronized+CAS+Node+红黑树**
  
  - Node的val和next都用volatile修饰，保证可见性
  
  - 查找、替换、赋值操作都使用CAS，效率更高（CAS是乐观锁）
  
  - 锁：锁链表的head节点，不影响其他元素的读写，锁的粒度更细，效率更高，扩容时会阻塞所有的读写操作、并发扩容
  
  - Node的val和next使用volatile修饰，读写线程对该变量互相可见
    
    数组用volatile修饰，保证扩容时被读线程感知。



    



# 四、JDK1.8的新特性有哪些

### 4.1  接口的默认方法

JDK 1.8 中允许接口中包含**默认方法**和**静态方法**，这使得接口可以更加灵活地扩展和演化。默认方法可以为接口提供一个默认的实现，从而避免了所有实现类都需要实现该方法的问题；静态方法可以为接口提供一些辅助方法，从而使得接口更加丰富和实用。

       

#### 4.1.1 默认方法

在Java SE 8中，接口中添加了一种新的方法类型，称为默认方法（Default Methods）或又称为扩展方法（Extension Methods）。默认方法是指在接口中定义的具有默认实现的方法，它们可以在接口中声明并提供默认的实现，而不需要实现类去实现这些方法。这使得接口可以像抽象类一样拥有具体的实现，从而更加灵活地支持接口的演化和扩展。默认方法为向现有接口添加新功能提供了一种简单的方式，同时也避免了破坏现有实现的风险。默认方法还可以被继承和重写，从而进一步提高了接口的灵活性和可复用性。

以下是一个简单的示例，展示了如何在接口中定义默认方法：

```java
public interface MyInterface {
    // 普通抽象方法
    void doSomething();

    // 默认方法
    default void doSomethingElse() {
        System.out.println("Doing something else in MyInterface");
    }
}
```

在上面的示例中，`MyInterface` 接口中定义了一个普通的抽象方法 `doSomething()`，并且通过 `default` 关键字定义了一个默认方法 `doSomethingElse()`。注意，`doSomethingElse()` 方法有一个默认的方法体，可以在实现类中直接调用，也可以在实现类中重写。

    

- <mark>**一个接口中可以有多个默认方法吗？**</mark>

是的，一个接口中可以有多个默认方法。

    

#### 4.1.2 静态方法

从Java SE 8开始，接口中可以定义静态方法（Static Methods）。在Java SE 7及之前的版本中，接口只能定义常量和抽象方法，不能定义静态方法。但是，Java SE 8引入了默认方法和静态方法，使得接口的功能更加强大。

以下是一个简单的示例，展示了如何在接口中定义静态方法：

```java
public interface MyInterface {
    // 静态方法
    static void doSomethingStatic() {
        System.out.println("Doing something static in MyInterface");
    }

    // 抽象方法
    void doSomething();
}
```

    

- **接口中的静态方法可以有多个吗?**

是的，接口中的静态方法可以有多个

    

### 4.2 Lambda 表达式

Lambda 表达式是 JDK 1.8 中最为重要的新特性之一，它可以简化代码，提高代码可读性。Lambda 表达式是一种匿名函数，它可以作为参数传递，也可以作为返回值返回。Lambda 表达式的语法非常简洁，可以用于实现函数式编程。

Lambda 表达式的基本语法如下：

```java
(parameter1, parameter2, ...) -> { statement1; statement2; ... }
```

其中，参数列表可以为空，也可以包含多个参数，参数之间用逗号分隔；箭头（->）用于将参数列表和方法体分隔开；方法体可以包含一个或多个语句，如果方法体只有一个语句，可以省略花括号。

    

### 4.3  函数式接口

JDK 1.8 中引入了函数式接口的概念，它是一种只包含一个抽象方法的接口，可以用于实现 Lambda 表达式和方法引用。函数式接口可以提高代码的可读性和可维护性，是实现函数式编程的基础。

函数式接口是一种只有一个抽象方法的接口，用于支持Lambda表达式和方法引用等功能。以下是一个函数式接口的例子：

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    int doSomething(int a, int b);
}
```

```java
public class functinalTest {
    public static void main(String[] args) {
        MyFunctionalInterface myFunction = (a, b) -> a + b;
        int result = myFunction.doSomething(10, 20);
        System.out.println(result); // 输出 30
    }
}

```





### 4.4 方法与构造函数引用

### 4.5 Lambda 作用域

### 4.6 访问局部变量

### 4.7 访问对象字段与静态变量

### 4.8 访问接口的默认方法

### 4.9 Date API

JDK 1.8 中引入了全新的 Date/Time API，提供了一组新的日期和时间类，可以更加方便地处理日期和时间。新的 Date/Time API 支持时区、日历、闰年等复杂的时间操作，同时也提供了一些方便的方法，可以使得代码更加简洁和易于理解。    

### 4.10  注解相关的新特性

Java SE 8中没有引入新的注解类型，但是它扩展了注解的用途，例如支持在接口中声明默认方法和静态方法，以及在Lambda表达式中使用注解。

多重注解（Repeated Annotations）是在Java SE 8中引入的新特性。它允许在同一个元素上多次使用相同类型的注解，从而简化了某些情况下使用注解的代码编写。在Java SE 8之前，每个元素只能使用一次特定类型的注解，如果需要多个相同类型的注解，就必须使用容器注解（Container Annotation）包装多个注解。多重注解的引入避免了这种冗余的代码编写。

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

    



# 七、HashMap原理

![](http://fastly.jsdelivr.net/gh/Sui-Xing/Figurebed//img/2023/04/18/20230418114738.png)

hashcode1与hashcode2在oldthreshold大小中 hash值是一样的，因此在一跳链表中

但 在newThr中，由于两个hashcode的第5位不同，因此&上newThr的hash也不同，因此在旧表中一条链上的两个值在新表中分别会在两个链上，这两个链的hash差了一个threshold

即 000**1** 0101-000**0** 0101=0001 0000





[TOC]

![hashmap](https://gitee.com/JupiterLi/img-bed/raw/master/img/hashmap.png)

    

## 常量

```java
/**
 * The default initial capacity - MUST be a power of two.
 *
 * 缺省table大小
 */
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

/**
 * The maximum capacity, used if a higher value is implicitly specified
 * by either of the constructors with arguments.
 * MUST be a power of two <= 1<<30.
 *
 * table最大长度
 */
static final int MAXIMUM_CAPACITY = 1 << 30;

/**
 * The load factor used when none specified in constructor.
 *
 *  缺省负载因子大小
 */
static final float DEFAULT_LOAD_FACTOR = 0.75f;

/**
 * The bin count threshold for using a tree rather than list for a
 * bin.  Bins are converted to trees when adding an element to a
 * bin with at least this many nodes. The value must be greater
 * than 2 and should be at least 8 to mesh with assumptions in
 * tree removal about conversion back to plain bins upon
 * shrinkage.
 *
 * 树化阈值
 */
static final int TREEIFY_THRESHOLD = 8;

/**
 * The bin count threshold for untreeifying a (split) bin during a
 * resize operation. Should be less than TREEIFY_THRESHOLD, and at
 * most 6 to mesh with shrinkage detection under removal.
 *
 * 树降级为链表的阈值
 */
static final int UNTREEIFY_THRESHOLD = 6;

/**
 * The smallest table capacity for which bins may be treeified.
 * (Otherwise the table is resized if too many nodes in a bin.)
 * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
 * between resizing and treeification thresholds.
 * 最小树形化容量阈值：即 当哈希表中的容量 > 该值时，才允许树形化链表 （即 将链表 转换成红黑树）
 * 否则，若桶内元素太多时，则直接扩容，而不是树形化
 * 为了避免进行扩容、树形化选择的冲突，这个值不能小于 4 * TREEIFY_THRESHOLD
 */
static final int MIN_TREEIFY_CAPACITY = 64;
```

    

## 变量

```java
 // 当前哈希表中元素个数
transient int size;


 // 哈希表结构改变次数
transient int modCount;


 // 扩容阈值，当你的哈希表中的元素超过阈值时，触发扩容
int threshold;


 // 负载因子
final float loadFactor;
```

    

## 静态内部类

### Class Node

桶即table数组，table数组中的每一个元素就是一个Node链表

```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}
```

    

## 构造函数

### 1号构造

传入initialCapacity、loadFactor

```java
/**
 * Constructs an empty {@code HashMap} with the specified initial
 * capacity and load factor.
 * @param  initialCapacity the initial capacity
 * @param  loadFactor      the load factor
 * @throws IllegalArgumentException if the initial capacity is negative
 *         or the load factor is nonpositive
 */
public HashMap(int initialCapacity, float loadFactor) {
    // 如果传入初始容量小于0，则抛出异常
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                initialCapacity);

    // 如果传入的初始容量大于table表最大长度，则令初试容量等于最大长度
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;

    // 如果传入的负载因子小于等于0，或者为空，则抛异常
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                loadFactor);


    this.loadFactor = loadFactor;

    //将本对象的扩容阈值设置为大于 传入的初始容量的 最小2的次方数
    this.threshold = tableSizeFor(initialCapacity);
}
```

      

#### tableSizeFor()函数

```java
/**
 * Returns a power of two size for the given target capacity.
 *
 * 通过位运算
 * 返回一个大于cap的最小2的次方数
 */
static final int tableSizeFor(int cap) {
    int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

    

#### Integer.numberOfLeadingZeros(int i)

```java
/**
 * Returns the number of zero bits preceding the highest-order
 * ("leftmost") one-bit in the two's complement binary representation
 * of the specified {@code int} value.  Returns 32 if the
 * specified value has no one-bits in its two's complement representation,
 * in other words if it is equal to zero.
 *
 * <p>Note that this method is closely related to the logarithm base 2.
 * For all positive {@code int} values x:
 * <ul>
 * <li>floor(log<sub>2</sub>(x)) = {@code 31 - numberOfLeadingZeros(x)}
 * <li>ceil(log<sub>2</sub>(x)) = {@code 32 - numberOfLeadingZeros(x - 1)}
 * </ul>
 *
 * @param i the value whose number of leading zeros is to be computed
 * @return the number of zero bits preceding the highest-order
 *     ("leftmost") one-bit in the two's complement binary representation
 *     of the specified {@code int} value, or 32 if the value
 *     is equal to zero.
 * @since 1.5
 * 
 * cap=6
 * i=5
 * BIN=...0000 0000 0000 0101
 *     
 */
@HotSpotIntrinsicCandidate
public static int numberOfLeadingZeros(int i) {
    // HD, Count leading 0's
    if (i <= 0)
        return i == 0 ? 32 : 0;

    // n =  0000 0000 0001 1111
    int n = 31;

    // 传入的i是否大于2的16次方， 
    if (i >= 1 << 16) { n -= 16; i >>>= 16; }
    if (i >= 1 <<  8) { n -=  8; i >>>=  8; }
    if (i >= 1 <<  4) { n -=  4; i >>>=  4; }

    // 传入的i是否大于2的2次方，如果是
    // 则 n = 0000 0000 0001 1101，十进制为29
    //    i = 0000 0000 0000 0001
    if (i >= 1 <<  2) { n -=  2; i >>>=  2; }

    // 返回  0000 0000 0001 1111，即29
    // 在tableSizeFor()函数中，-1无符号右移29位，
    // -1为4个字节，占32位，二进制是32个1,
    // 无符号右移29位，剩下最右边3个1，即...0000 0111,即是7
    // 最后得到结果8
    return n - (i >>> 1);
}

```

    

### 2号构造

传入initialCapacity

```java
/**
 * Constructs an empty {@code HashMap} with the specified initial
 * capacity and the default load factor (0.75).
 *
 * @param  initialCapacity the initial capacity.
 * @throws IllegalArgumentException if the initial capacity is negative.
 * 
 * 套娃调用了1号构造
 */
public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}
```

    

### 3号构造

啥都不传

```java
/**
 * Constructs an empty {@code HashMap} with the default initial capacity
 * (16) and the default load factor (0.75).
 */
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}
```

    

### 4号构造

传入一个map

```java
/**
 * Constructs a new {@code HashMap} with the same mappings as the
 * specified {@code Map}.  The {@code HashMap} is created with
 * default load factor (0.75) and an initial capacity sufficient to
 * hold the mappings in the specified {@code Map}.
 *
 * @param   m the map whose mappings are to be placed in this map
 * @throws  NullPointerException if the specified map is null
 */
public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    putMapEntries(m, false);
}
```

    

## put(K,V)函数

```java
/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with {@code key}, or
 *         {@code null} if there was no mapping for {@code key}.
 *         (A {@code null} return can also indicate that the map
 *         previously associated {@code null} with {@code key}.)
 */
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

    

## hash(Object)函数

```java
/**
 * 让key的哈希值右移16位就是为了让高的16位和低位相亦或
 * (如果这两个二进制位的值不同，则结果为1，否则结果为0)，
 * 发挥作用，影响低位的值，
 * 这样路由寻址table的index时，
 * 能够让高16位也参与这个应该存放的位置（index）的计算
 * 
 * index的计算是(table.len-1)|hashcode_*
 * 因为len-1的为2的倍数-1，所以为1111形式的，
 * 前面的0经过与还是0，因此得到的index必小于len
 */
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

    

## putVal(int, K, V, boolean,boolean)函数

```java
/**
 * Implements Map.put and related methods.
 *
 * @param hash hash for key
 * @param key the key
 * @param value the value to put
 * @param onlyIfAbsent if true, don't change existing value
 * @param evict if false, the table is in creation mode.
 * @return previous value, or null if none
 */
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {

    // tab 表示引用当前hashmap的散列表，也就是一个Node数组，
    // 被需要put的Node数组赋值了
    // p是指一个Node节点，也就是hasmap散列表（Node数组）里的一个链表（Node）
    // n表示数组长度
    // i表示路由寻址结果
    Node<K,V>[] tab; Node<K,V> p; int n, i;

    // 将需要put元素的table赋值给tab，将散列表（数组）的长度赋值给n
    // 判断散列表是否为空或散列表长度是否为0，如果为真就为tab进行扩容
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;

    // 将tab需要put的key对应的数组上的索引的Node链表赋值给p,
    // 将key对应的hash索引赋值给i
    // 判断p是否为空,为空就直接将第i个空间赋值给
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;

        // 如果索引碰撞了，
        // 而且需要put的node节点的hash值和table数组的索引i位置
        // 的node链表p（链表中第一个元素）的hash值一样，那么替换原位置的node
        if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;

        // 如果p的结构是红黑树，则、、、
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            // 如果p的结构是链表，而且链表的头节点与要put的节点不同
            for (int binCount = 0; ; ++binCount) {
                // 如果遍历到尾节点
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);

                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        // 因为上上面一行代码又添加了一个Node节点，所以此时该链表有9个节点
                        treeifyBin(tab, hash);
                    break;
                }
                // 如果hash值发生了碰撞，则进行下面的替换操作
                if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }

        // 如果hash值碰撞了，就进行替换操作，
        // 将传进来的参数value赋值给链表中碰撞位置的node节点的value值
        // 最后返回旧的value值
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}     
```

    

## 扩容函数resize()

```java
// 为什么需要扩容？
// 为了解决hash值冲突导致的链化影响查询效率，最大时间复杂度为O(logN),即为红黑树的查找效率，
// 扩容会缓解该问题

// oldTab赋值为table
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;

    // 如果进行扩容的table数组的容量（长度）大于0

    if (oldCap > 0) {
        // 如果table数组长度大于最大容量，扩容阈值直接等于整型最大值
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }

        // 旧的数组长度乘2等于新的数组长度，如果table数组长度乘2后小于最大值
        // 且被扩容的table数组长度大于默认初始长度
        // 那么新的扩容阈值就等于旧的扩容阈值乘2，也就是进行了新的表长度乘loadfactor的模糊操作，
        // 该操作在oldCap < DEFAULT_INITIAL_CAPACITY时不精确
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }

    // 如果进行扩容的table数组的容量（长度）等于0，
    // 且当此时的扩容阈值大于0时。此时的情况是构造hashmap时传入了初始table表长度（initcap），而表中又没有数据。
    // 1.new Hashmap(initCap,loadFactor)
    // 2.new Hashmap(loadFactor)
    // 3.new Hashmap(map)
    // 则将扩容后的表的长度设置为扩容阈值，此时的扩容阈值没有进行   表长度乘loadfactor的操作
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;

        // 如果进行扩容的table数组的容量（长度）等于0，
        // 且当此时的扩容阈值等于0时。也就是new HashMap()时
        // 扩容后的表长度为默认长度，扩容后的表扩容阈值等于默认容量乘扩容阈值。
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }


    // 1.new Hashmap(initCap,loadFactor)
    // 2.new Hashmap(loadFactor)
    // 3.new Hashmap(map)
    // 4.当被扩容table数组的长度小于默认长度时
    // 扩容后的表的扩容阈值为 扩容后表的长度乘loadfactor
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    // 以上所有步骤都是为了确定应该扩容成多大的数组，以及扩容后数组的扩容阈值


    // 为了建一个又长又大的数组
    @SuppressWarnings({"rawtypes","unchecked"})
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;


    // oldTab != null说明本次扩容之前table不为null，table已经指向了一个数组
    if (oldTab != null) {

        // 便利table数组
        for (int j = 0; j < oldCap; ++j) {

            // table数组的每个元素的头节点赋值给e
            Node<K,V> e;

            // 如果这个头节点不为空
            if ((e = oldTab[j]) != null) {
                // 方便JVM GC时回收内存
                oldTab[j] = null;

                // 如果头节点e的指针指向下一个的地址为空
                // 那么就直接令新表的头节点e对应的索引位置的元素为e
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;

                // 如果e是个树
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);

                // 如果e是个链表
                else { // preserve order

                    // 对e链表进行拆分，分成扩容之后索引不变的，和索引改变的两条链表
                    // 新建一个低位链表，该链表的hash值在newCap最高位位置上为0
                    Node<K,V> loHead = null, loTail = null;
                    // 新建一个低位链表，该链表的hash值在newCap最高位位置上为1，即该链表的节点在扩容后的索引位置是原索引位置 +oldCap
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {


                        next = e.next;
                        // e的hash值与（&）上扩容前的数组长度，

                        // 例如oldCap=16（1 0000）    e的hash值：...0 1100， 
                        // & 之后的结果为...0 0000,此时为0，则该链表节点需要置到低位链表
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }

                        // 例如oldCap=16（1 0000）    e的hash值：...1 1100， 
                        // & 之后的结果为...1 0000,此时不为0，则该链表节点需要置到高位链表
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);

                    // 将高位与低位两个链表的尾节点的next设为空
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```

    

## 红黑树函数

### treeifyBin(Node, int)

```java
/**
 * tab：元素数组，
 * hash：hash值（要增加的键值对的key的hash值）
 */
final void treeifyBin(Node<K,V>[] tab, int hash) {

    int n, index; Node<K,V> e;
    /*
     * 如果元素数组为空 或者 数组长度小于 树结构化的最小限制
     * MIN_TREEIFY_CAPACITY 默认值64，对于这个值可以理解为：如果元素数组长度小于这个值，没有必要去进行结构转换
     * 当一个数组位置上集中了多个键值对，那是因为这些key的hash值和数组长度取模之后结果相同。（并不是因为这些key的hash值相同）
     * 因为hash值相同的概率不高，所以可以通过扩容的方式，来使得最终这些key的hash值在和新的数组长度取模之后，拆分到多个数组位置上。
     */
    if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
        resize(); // 扩容，可参见resize方法解析

    // 如果元素数组长度已经大于等于了 MIN_TREEIFY_CAPACITY，那么就有必要进行结构转换了
    // 根据hash值和数组长度进行取模运算后，得到链表的首节点
    else if ((e = tab[index = (n - 1) & hash]) != null) { 
        TreeNode<K,V> hd = null, tl = null; // 定义首、尾节点
        do { 
            TreeNode<K,V> p = replacementTreeNode(e, null); // 将该节点转换为 树节点
            if (tl == null) // 如果尾节点为空，说明还没有根节点
                hd = p; // 首节点（根节点）指向 当前节点
            else { // 尾节点不为空，以下两行是一个双向链表结构
                p.prev = tl; // 当前树节点的 前一个节点指向 尾节点
                tl.next = p; // 尾节点的 后一个节点指向 当前节点
            }
            tl = p; // 把当前节点设为尾节点
        } while ((e = e.next) != null); // 继续遍历链表

        // 到目前为止 也只是把Node对象转换成了TreeNode对象，把单向链表转换成了双向链表

        // 把转换后的双向链表，替换原来位置上的单向链表
        if ((tab[index] = hd) != null)
            hd.treeify(tab);//此处单独解析
    }
}
```

原文链接：https://blog.csdn.net/weixin_42340670/article/details/80503863

    

### treeify(Node)

```java
/**
 * 参数为HashMap的元素数组
 */
final void treeify(Node<K,V>[] tab) {
    TreeNode<K,V> root = null; // 定义树的根节点
    for (TreeNode<K,V> x = this, next; x != null; x = next) { // 遍历链表，x指向当前节点、next指向下一个节点
        next = (TreeNode<K,V>)x.next; // 下一个节点
        x.left = x.right = null; // 设置当前节点的左右节点为空
        if (root == null) { // 如果还没有根节点
            x.parent = null; // 当前节点的父节点设为空
            x.red = false; // 当前节点的红色属性设为false（把当前节点设为黑色）
            root = x; // 根节点指向到当前节点
        }
        else { // 如果已经存在根节点了
            K k = x.key; // 取得当前链表节点的key
            int h = x.hash; // 取得当前链表节点的hash值
            Class<?> kc = null; // 定义key所属的Class
            for (TreeNode<K,V> p = root;;) { // 从根节点开始遍历，此遍历没有设置边界，只能从内部跳出
                // GOTO1
                int dir, ph; // dir 标识方向（左右）、ph标识当前树节点的hash值
                K pk = p.key; // 当前树节点的key
                if ((ph = p.hash) > h) // 如果当前树节点hash值 大于 当前链表节点的hash值
                    dir = -1; // 标识当前链表节点会放到当前树节点的左侧
                else if (ph < h)
                    dir = 1; // 右侧

                /*
                 * 如果两个节点的key的hash值相等，那么还要通过其他方式再进行比较
                 * 如果当前链表节点的key实现了comparable接口，并且当前树节点和链表节点是相同Class的实例，那么通过comparable的方式再比较两者。
                 * 如果还是相等，最后再通过tieBreakOrder比较一次
                 */
                else if ((kc == null &&
                            (kc = comparableClassFor(k)) == null) ||
                            (dir = compareComparables(kc, k, pk)) == 0)
                    dir = tieBreakOrder(k, pk);

                TreeNode<K,V> xp = p; // 保存当前树节点

                /*
                 * 如果dir 小于等于0 ： 当前链表节点一定放置在当前树节点的左侧，但不一定是该树节点的左孩子，也可能是左孩子的右孩子 或者 更深层次的节点。
                 * 如果dir 大于0 ： 当前链表节点一定放置在当前树节点的右侧，但不一定是该树节点的右孩子，也可能是右孩子的左孩子 或者 更深层次的节点。
                 * 如果当前树节点不是叶子节点，那么最终会以当前树节点的左孩子或者右孩子 为 起始节点  再从GOTO1 处开始 重新寻找自己（当前链表节点）的位置
                 * 如果当前树节点就是叶子节点，那么根据dir的值，就可以把当前链表节点挂载到当前树节点的左或者右侧了。
                 * 挂载之后，还需要重新把树进行平衡。平衡之后，就可以针对下一个链表节点进行处理了。
                 */
                if ((p = (dir <= 0) ? p.left : p.right) == null) {
                    x.parent = xp; // 当前链表节点 作为 当前树节点的子节点
                    if (dir <= 0)
                        xp.left = x; // 作为左孩子
                    else
                        xp.right = x; // 作为右孩子
                    root = balanceInsertion(root, x); // 重新平衡
                    break;
                }
            }
        }
    }

    // 把所有的链表节点都遍历完之后，最终构造出来的树可能经历多个平衡操作，根节点目前到底是链表的哪一个节点是不确定的
    // 因为我们要基于树来做查找，所以就应该把 tab[N] 得到的对象一定根节点对象，而目前只是链表的第一个节点对象，所以要做相应的处理。
    moveRootToFront(tab, root); // 单独解析
}
```

原文链接：https://blog.csdn.net/weixin_42340670/article/details/80531795
