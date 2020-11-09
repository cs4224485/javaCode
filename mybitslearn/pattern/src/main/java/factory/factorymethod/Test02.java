package factory.factorymethod;

public class Test02 {
    public static void main(String[] args) {
        IphoneFactory iphoneFactory = new IPhoneXFactory();
        IPhone iphonex = iphoneFactory .produce();
        iphonex.play();
    }
}
