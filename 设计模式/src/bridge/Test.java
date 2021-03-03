package bridge;

public class Test {
    public static void main(String[] args) {
        Desktop desktop1 = new Desktop(new Apple());
        desktop1.info();

        Laptop laptop = new Laptop(new Dell());
        laptop.info();


    }
}
