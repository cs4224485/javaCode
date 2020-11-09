package factory.factorymethod;




/**
 * 生产Iphone 8 plus的工厂
 */
public class IPhone8plusFactory implements IphoneFactory{
    public IPhone produce() {
        return new Iphone8Plus();
    }
}
