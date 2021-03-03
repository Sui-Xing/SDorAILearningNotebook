package staticproxy.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        contract();
        seeHouse();
        fee();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void contract(){
        System.out.println("签合同");
    }

    public void fee(){
        System.out.println("中介收中介费");
    }
}
