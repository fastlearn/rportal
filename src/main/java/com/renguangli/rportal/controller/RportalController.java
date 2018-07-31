package com.renguangli.rportal.controller;

import org.springframework.stereotype.Controller;
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
    public String index() {
        return "index";
    }
}
