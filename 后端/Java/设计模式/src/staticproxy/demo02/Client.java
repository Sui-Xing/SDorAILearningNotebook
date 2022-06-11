package staticproxy.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        //
        // userService.add();
        Proxy proxy=new Proxy();
        proxy.setUserService(userService);
        proxy.add();
        proxy.query();
    }

}
