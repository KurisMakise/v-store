package store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "classpath:/mybatis/*/sqlMap/*Mapper.xml",basePackages = "store.*.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
