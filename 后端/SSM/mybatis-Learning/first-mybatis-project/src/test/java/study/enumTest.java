package study;
/**
 * 此类用于演示使用enum关键字定义枚举类【掌握】
 * 引入：jdk5.0出现的新特性
 * 特点：
 *         1、使用enum关键字代替class关键字
 *         2、对象（常量）的创建必须放在枚举类中的第一句
 *         语法：
 *         对象名(实参列表),对象名(实参列表);
 *         3、如果是无参构造，则无参构造的定义和实参列表都可以省略
 *
 */

enum Season2{
    //2.本类内部创建一组对象，添加public static修饰符，直接暴露对象
    SPRING("春天","春风又绿江大南"),
    SUMMER ("夏天","接天莲叶无穷碧"),
    AUTUMN ("秋天","霜叶红于二月花"),
    WINTER("冬天","千树万树梨花开");

    private String name;
    private String description;

    //1、构造器私有化
    private Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}

//简单示例1：使用无参构造器：枚举常量
enum Gender2{
    BOY,GIRL;
}
public class enumTest {
    public static void main(String[] args) {
        //引用枚举类的对象
        //示例1：
        System.out.println(Gender2.GIRL);

        //示例2：
        System.out.println(Season2.SUMMER.getName());
    }
}
