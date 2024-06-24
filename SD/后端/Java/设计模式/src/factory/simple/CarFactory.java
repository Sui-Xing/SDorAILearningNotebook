package factory.simple;

public class CarFactory {
    // 方法一
    public static Car getCar(String car){
        if(car.equals("五菱")){
            return new WuLing();
        }else if(car.equals("特斯拉")){
            return new Tesla();
        }else {
            return null;
        }
    }


    // 方法二
    public static Car getWuLing(){
        return new WuLing();
    }
    public static Car getTesla(){
        return new Tesla();
    }

}
