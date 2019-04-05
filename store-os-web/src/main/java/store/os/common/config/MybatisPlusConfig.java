package store.os.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * mybatisPlus插件
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/4 14:55
 */
@EnableTransactionManagement
@Configuration
@MapperScan("store.*.mapper")
public class MybatisPlusConfig {

    /**
     * @return 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
