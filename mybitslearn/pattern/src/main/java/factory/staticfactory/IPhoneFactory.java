package factory.staticfactory;

public class IPhoneFactory {
    public static Iphone produce(String model){
        if ("iPhonex".equalsIgnoreCase(model)){
            // 生产IPhoebeX对象
            return new IphoneX();
        }else if ("iPhone8plus".equalsIgnoreCase(model)){
            // 生产iPhone8 Plus
            return new Iphone8Plus();
        }else {
            return null;
        }

    }
}
