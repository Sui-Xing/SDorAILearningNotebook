package staticproxy.demo02;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加操作");
    }

    @Override
    public void delete() {
        System.out.println("删除操作");

    }

    @Override
    public void update() {
        System.out.println("更新操作");

    }

    @Override
    public void query() {
        System.out.println("查找操作");

    }
}
