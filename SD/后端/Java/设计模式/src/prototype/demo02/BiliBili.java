package prototype.demo02;



import java.util.Date;

public class BiliBili {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        // 深克隆
        Video v1 = new Video("狂神说Java", date);
        System.out.println("v1=>"+v1.toString());
        System.out.println("v1 hashcode=>"+v1.hashCode());
        Video v2 = (Video) v1.clone();

        System.out.println("v2=>"+v2.toString());
        System.out.println("v2 hashcode=>"+v2.hashCode());
        System.out.println("================");
        System.out.println("改变data");
        System.out.println("================");
        date.setTime(214123412);
        System.out.println("v1=>"+v1.toString());
        System.out.println("v1 hashcode=>"+v1.hashCode());
        System.out.println("v2=>"+v2.toString());
        System.out.println("v2 hashcode=>"+v2.hashCode());


    }
}

