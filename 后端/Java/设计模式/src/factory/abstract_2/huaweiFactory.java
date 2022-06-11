package factory.abstract_2;

public class huaweiFactory implements ProductFactory {
    @Override
    public IPhoneProduct produceIPhone() {
        return new huaweiIPhone();
    }

    @Override
    public IRouterProduct produceIRouter() {
        return new huaweiIRouter();
    }
}
