import com.harry.spring.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        // 关闭容器
        applicationContext.close();
    }


    @Test
    public void test02() {
        // 1. 使用无参构造器创建一个IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 2. 在我们容器还没启动创建其他bean之前，先设置需要激活的环境（可以设置激活多个环境哟）
        applicationContext.getEnvironment().setActiveProfiles("test");
        // 3. 注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        // 4. 启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        // 关闭容器
        applicationContext.close();
    }

}
