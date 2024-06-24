import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_Date {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        String l = System.currentTimeMillis()+"";
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.parseLong(l)));


        System.out.println(format);

    }
}
