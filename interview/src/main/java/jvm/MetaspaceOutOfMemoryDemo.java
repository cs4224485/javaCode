//package jvm;
//
//import java.lang.reflect.Method;
//
//public class MetaspaceOutOfMemoryDemo {
//
//    static class OOMTest{}
//
//    public static void main(String[] args) {
//        // 模拟计数多少次后发生异常
//        int i = 0;
//        try {
//            while (true){
//                i++;
//                // 使用Spring的动态字节码技术
//                Enhancer enhancer = new Enhancer();
//                enhancer.setSuperclass(OOMTest.class);
//                enhancer.setUseCache(false);
//                enhancer.setCallback(new MethodInterceptor() {
//                    @Override
//                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                        return methodProxy.invokeSuper(o, args);
//                    }
//                });
//            }
//        }catch (Exception e){
//            System.out.println("发生异常的次数:" + i);
//            e.printStackTrace();
//        }finally {
//
//        }
//    }
//}
