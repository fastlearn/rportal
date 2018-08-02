package com.renguangli.rportal.controller;

import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * RportalController
 *
 * @author renguangli 2018/7/31 17:35
 * @since JDK 1.8
 */
@Controller
public class RportalController {

    @Resource
    private ConfigService configService;

    @GetMapping(value = {"", "/", "index", "home"})
    public String index(Model model) {
        List<Config> configs = configService.listConfig("siteName", "indexUrl");
        configs.forEach(config -> model.addAttribute(config.getName(), config.getValue()));
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }

}
