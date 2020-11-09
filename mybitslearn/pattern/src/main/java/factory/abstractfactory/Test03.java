package factory.abstractfactory;



public class Test03 {
    public static void main(String[] args) {
        IPhoneXFactory iphoneFactory = new IPhoneXFactory();
        Telephone telephone = iphoneFactory.producePhone();
        Charger appleCharger = iphoneFactory.produceCharger();
        appleCharger.charge();
        telephone.play();
    }
}
