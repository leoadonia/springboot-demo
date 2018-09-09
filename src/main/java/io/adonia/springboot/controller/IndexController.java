package io.adonia.springboot.controller;

import io.adonia.springboot.config.BlogConfig;
import io.adonia.springboot.dal.IUserDAO;
import io.adonia.springboot.dal.entity.User;
import io.adonia.springboot.model.BlogParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo
 * @create 2018/9/9
 */
@RestController
@Slf4j
public class IndexController {

    @Resource
    private BlogConfig blogConfig;

    @Resource
    private IUserDAO userDAO;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        log.info("enter index.");
        return "welcome";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blog() {
        log.info("enter blog.");
        return "name: " + blogConfig.getName() + ", address: " +
                blogConfig.getAddress() + ", books: " + Arrays.asList(blogConfig.getBooks())
                + ", age: " + blogConfig.getAge();
    }

    @RequestMapping(value = "/blogs/{id}")
    public String blog(@PathVariable("id") Integer id) {
        if(id == null || id < 1) {
            throw new IllegalArgumentException("id不合法");
        }
        return "id";
    }

    @RequestMapping(value = "/valid")
    public String testValid(@Valid BlogParam param) {
        log.info("");
        return "ddddd";
    }

    @RequestMapping("/users")
    public List<User> getAllUser() {
        List<User> users = userDAO.selectUserList();
        return users;
    }

}
