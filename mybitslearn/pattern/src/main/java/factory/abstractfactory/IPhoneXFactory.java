package factory.abstractfactory;

/**
 * 苹果的生产线
 */
public class IPhoneXFactory implements PhoneFactory {
    public Telephone producePhone() {
        return new IphoneX();
    }

    public Charger produceCharger() {
        return new AppleCharger();
    }
}
