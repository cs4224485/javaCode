package factory.factorymethod;


/**
 * 生产iPhone X的工厂
 */
public class IPhoneXFactory implements IphoneFactory {
    public IPhone  produce() {
        return new IphoneX();
    }
}
