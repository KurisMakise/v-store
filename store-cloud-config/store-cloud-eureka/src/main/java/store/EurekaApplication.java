package store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * eureka注册服务
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/17 19:52
 */


@SpringBootApplication
@EnableEurekaServer
 public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class);
    }
}
