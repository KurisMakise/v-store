package store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/21 13:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OnlineServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineServiceApplication.class, args);
    }
}
