package basic;

public  class InnerClass {
    public class A{

        public String aTest = "a";
        public void  test(){
            System.out.println(aTest);
        }
    }

    public static  class B{
        public void  test(){
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        B b = new B();
        Thread.interrupted();
        b.test();
        String test1 = "aaa";
        String test2 = new String("aaa");
        System.out.println(test1==test2);
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(-1.5));
    }
}
