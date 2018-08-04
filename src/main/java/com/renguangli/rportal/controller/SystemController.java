package com.renguangli.rportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * DashboardController
 *
 * @author renguangli 2018/8/2 12:57
 * @since JDK 1.8
 */
@RestController
public class SystemController {

    @GetMapping("/monitor")
    public String monitor(Model model) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        double memory = ((double)(totalMemory - freeMemory) / totalMemory)  * 100;
        double cpu = Math.random() * 100;
        return "{\"cpu\":"  + cpu + ", \"memory\":"  + memory + "}";
    }

}
