package factory.abstractfactory;

/**
 * 生产手机的大工厂
 * 要生产手机和相应的充电器
 */
public interface PhoneFactory {
    Telephone producePhone();
    Charger produceCharger();
}
