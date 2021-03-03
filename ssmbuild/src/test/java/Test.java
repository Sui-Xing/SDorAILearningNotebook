import com.tf.pojo.Books;
import com.tf.service.BookService;
import com.tf.service.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookServiceImpl.class);

        List<Books> books = bookService.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }

    }
}
