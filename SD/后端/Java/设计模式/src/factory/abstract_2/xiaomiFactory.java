package factory.abstract_2;

public class xiaomiFactory implements ProductFactory{
    @Override
    public IPhoneProduct produceIPhone() {
        return new xiaomiIPhone();
    }

    @Override
    public IRouterProduct produceIRouter() {
        return new xiaomiIRouter();
    }
}
