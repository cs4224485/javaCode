import com.harry.spring.config.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        // 发布一个事件
        applicationContext.publishEvent(new ApplicationEvent(new String("自己发布的事件")) {
        });
        // 关闭容器
        applicationContext.close();
    }

}
