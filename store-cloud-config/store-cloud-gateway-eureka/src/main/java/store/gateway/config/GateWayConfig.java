package store.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * <p>
 * 网关配置
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/20 13:21
 */
@Configuration
public class GateWayConfig {


    /**
     * 根据请求参数中的 user 字段来限流
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> {
            String first = exchange.getRequest().getQueryParams().getFirst("user");
            if (first == null)
                return null;
            return Mono.just(first);
        };
    }

    /**
     * 根据请求IP地址来限流
     */
    @Bean
    public KeyResolver hostNameResolver () {
        return (ServerWebExchange exchange) -> {
            InetSocketAddress remoteAddress = exchange.getRequest().getRemoteAddress();
            if (remoteAddress == null)
                return null;
            return Mono.just(remoteAddress.getHostName());
        };
    }
    /**
     * 根据请求 hostAddress 地址来限流
     */
    @Bean
    public KeyResolver hostAddressKeyResolver () {
        return (ServerWebExchange exchange) -> {
            InetSocketAddress remoteAddress = exchange.getRequest().getRemoteAddress();
            if (remoteAddress == null)
                return null;
            return Mono.just(remoteAddress.getAddress().getHostAddress());
        };
    }

    /**
     * 根据请求路径限流
     */
    @Bean
    public KeyResolver uriKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }
}
