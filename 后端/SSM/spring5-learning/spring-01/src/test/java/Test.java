import com.tf.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void dosth(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConfig.xml");


        People people = context.getBean("people", People.class);
        people.getCat().dosth();
        people.getDog().dosth();
    }

    @org.junit.Test
    public void dosth_2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConfig_2.xml");


        People people = context.getBean("people2", People.class);
        people.getCat().dosth();
        people.getDog().dosth();

    }
}
