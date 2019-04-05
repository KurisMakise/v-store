package store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement// 启动注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
//@EnableScheduling//启动注解定时任务
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
