package com.renguangli.rportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * RportalController
 *
 * @author renguangli 2018/7/31 17:35
 * @since JDK 1.8
 */
@Controller
public class RportalController {

    @GetMapping(value = {"", "/", "index", "home"})
    public String index(Model model) {
        String title = "后台管理系统";
        String index = "https://www.baidu.com";

        model.addAttribute("title", title);
        model.addAttribute("index", index);
        return "index";
    }
}
