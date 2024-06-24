import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString_01 {
    public static void main(String[] args) throws IOException {

//        test_01();
        test_02();
    }

    public static void test_01() throws IOException {
        String str="\\a\\a\\q1q2";

        String str_1 = str.substring(str.indexOf("a"));
        System.out.println(str_1);
        System.out.println(new File(".").getAbsolutePath());
        try{
            FileInputStream fileInputStream = new FileInputStream(".\\src\\liulanqi_xingkong.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("realpic.jpg");
            int len=0;
            byte[] buffer=new byte[30000];
            while((len=fileInputStream.read(buffer))>0){
                fileOutputStream.write(buffer,0,len);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void test_02(){
        String str="\\a\\a\\q1q2";
        String pat=".*\\\\(.*)";
        Pattern a = Pattern.compile(pat);
        Matcher matcher = a.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(1));
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(start+"||"+end);
            System.out.println(str.substring(start,end));
        }



    }

}

