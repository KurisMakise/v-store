package store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/17 23:51
 */
@RestController
public class HelloController {

    @Value("${spring.datasource.driver-class-name}")
    private String test;

    @RequestMapping("/hello")
    public String hello(String name, HttpServletRequest httpServletRequest) {
        return test;
    }
}
