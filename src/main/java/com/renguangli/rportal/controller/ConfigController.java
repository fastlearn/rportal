package com.renguangli.rportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ConfigController
 *
 * @author renguangli 2018/8/1 16:45
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @GetMapping("/system")
    public String config(String title, Model model) {
        model.addAttribute("title", title);
        return "config/system";
    }

    @PostMapping("/system")
    public String updateConfig(String title, Model model) {
        model.addAttribute("title", title);
        return "config/system";
    }
}
