package factory.abstract_2;

public class Client {
    public static void main(String[] args) {

        System.out.println("===========小米系列产品===========");
        xiaomiFactory xf=new xiaomiFactory();
        IPhoneProduct xiaomiIPhoneProduct= xf.produceIPhone();
        xiaomiIPhoneProduct.open();
        xiaomiIPhoneProduct.callUp();
        IRouterProduct xiaomiIRouterProduct = xf.produceIRouter();
        xiaomiIRouterProduct.open();
        xiaomiIRouterProduct.openWifi();
        System.out.println();
        System.out.println("===========华为系列产品===========");
        huaweiFactory hf=new huaweiFactory();
        IPhoneProduct huaweiIPhoneProduct = hf.produceIPhone();
        huaweiIPhoneProduct.open();
        huaweiIPhoneProduct.callUp();

        IRouterProduct huaweiIRouterProduct = hf.produceIRouter();
        huaweiIRouterProduct.open();
        huaweiIRouterProduct.openWifi();
    }



}
