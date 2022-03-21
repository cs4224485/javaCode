package basic;

public class Singleton3 {
    public static Singleton3 instance;
    static {
        instance = new Singleton3();
    }
    private Singleton3(){}
}
