import com.harry.spring.aop.MathCalculator;
import com.harry.spring.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        // 不要自己创建这个对象
        // MathCalculator mathCalculator = new MathCalculator();
        // mathCalculator.div(1, 1);

        // 不要自己创建这个对象
//         MathCalculator mathCalculator = new MathCalculator();
//         mathCalculator.div(1, 1);

        // 我们要使用Spring容器中的组件
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);

        // 关闭容器
        applicationContext.close();
    }

}
