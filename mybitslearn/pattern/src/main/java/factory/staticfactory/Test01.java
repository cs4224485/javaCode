package factory.staticfactory;

public class Test01 {
    public static void main(String[] args) {
        //生产IphoneX手机
        Iphone iphonex = IPhoneFactory.produce("iphone");
        iphonex.play();
    }
}
