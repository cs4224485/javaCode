package factory.abstractfactory;

/**
 * 生产小米8手机的工厂
 */
public class XiaoMi8Factory implements PhoneFactory {
    public Telephone producePhone() {
        return new XiaoMi8();
    }

    public Charger produceCharger() {
        return new XiaoMiCharger();
    }
}
