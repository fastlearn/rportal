package com.renguangli.rportal.controller;

import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * RportalController
 *
 * @author renguangli 2018/7/31 17:35
 * @since JDK 1.8
 */
@Controller
public class RportalController {

    private final ConfigService configService;

    @Autowired
    public RportalController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping(value = {"", "/", "index", "home"})
    public String index(Model model) {
        String[] names = {"title", "index"};
        List<Config> configs = configService.listConfig(names);
        configs.forEach(config -> model.addAttribute(config.getName(), config.getValue()));
        return "index";
    }
}
