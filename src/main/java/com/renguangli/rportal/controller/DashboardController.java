package com.renguangli.rportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * DashboardController
 *
 * @author renguangli 2018/8/2 12:57
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping(value = {"", "/"})
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/monitor")
    public String monitor() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        Random random = new Random();
        int totalCpu = random.nextInt(1);
        int freeCpu = random.nextInt(2);
        return "dashboard";
    }

}
