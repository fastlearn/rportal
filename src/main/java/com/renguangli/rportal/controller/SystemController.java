package com.renguangli.rportal.controller;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

;


/**
 * DashboardController
 *
 * @author renguangli 2018/8/2 12:57
 * @since JDK 1.8
 */
@RestController
public class SystemController {

    @GetMapping("/monitor")
    public String monitor() {
        OperatingSystemMXBean system = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalMemory = system.getTotalPhysicalMemorySize();
        long freeMemory = system.getFreePhysicalMemorySize();
        double memory = ((double)(totalMemory - freeMemory) / totalMemory)  * 100;

        double cpu = system.getSystemCpuLoad() * 100;
        return "{\"cpu\":"  + cpu + ", \"memory\":"  + memory + "}";
    }

}
