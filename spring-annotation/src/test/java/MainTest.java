import com.harry.spring.bean.MainConfigOfPropertyValues;
import com.harry.spring.bean.Person;
import com.harry.spring.config.MainConfig;
import com.harry.spring.config.MainConfig2;
import com.harry.spring.config.MainConfig3;
import com.harry.spring.config.MainConfigOfLifeCycle;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainTest {
    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

    }
    @Test
    public void test02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        // 获取到的这个Person对象默认是单实例的，因为在IOC容器中给我们加的这些组件默认都是单实例的，
        // 所以说在这儿我们无论多少次获取，获取到的都是我们之前new的那个实例对象
        Person person = (Person) applicationContext.getBean("Person2");
        Person person2 = (Person) applicationContext.getBean("Person2");
        System.out.println(person == person2);
    }
    @Test
    public void test05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器创建完成");
        Person person = (Person) applicationContext.getBean("Person2");
        String[] namesForType = applicationContext.getBeanDefinitionNames();
        for (String name : namesForType) {
            System.out.println(name);
        }
        // 工厂bean获取的是调用getObject方法创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + bean2.getClass());
    }

    @Test public void test06(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        System.out.println("IOC容器创建完成");
        String[] namesForType = applicationContext.getBeanDefinitionNames();
        for (String name : namesForType) {
            System.out.println(name);
        }

    }

    @Test
    public void test07(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC容器创建完成");
        String[] namesForType = applicationContext.getBeanDefinitionNames();
//        for (String name : namesForType) {
//            System.out.println(name);
//        }

    }
    @Test
    public void test08(){
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        // 关闭容器
        applicationContext.close();
    }
}
