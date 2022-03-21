package basic;

/***
 * 在内部类被加载和初始化时才创建INSTANCE实例对象
 * 静态内部类不会自动随外部类的加载和初始化而初始化，它是要单独去加载和初始化的
 * 因为是在内部类加载和初始化创建的，因此线程是安全的
 */
public class Singleton6 {
    private Singleton6(){};
    private static class Inner{
        private static Singleton6 instance = new Singleton6();
    }
    public static Singleton6 getInstance(){
        return Inner.instance;
    }
}
