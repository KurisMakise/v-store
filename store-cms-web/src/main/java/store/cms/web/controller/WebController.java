package store.cms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import store.web.mapper.EmailMapper;

/**
 * @creator violet
 * @createTime 2019/3/5
 * @description
 */
@Controller
public class WebController {

    @Autowired
    private EmailMapper emailMapper;
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/index")
    public String index() {
        emailMapper.deleteByPrimaryKey(1000086L);
        return "index";
    }

    @RequestMapping("/index1")
    public String index1() {
        return "index1";
    }
}
