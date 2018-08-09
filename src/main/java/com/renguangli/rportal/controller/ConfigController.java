package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.Config;
import com.renguangli.rportal.pojo.Result;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ConfigController
 *
 * @author renguangli 2018/8/1 16:45
 * @since JDK 1.8
 */
@RestController
public class ConfigController {

    @Resource
    private ConfigService configService;

    @GetMapping("/configs")
    public Result listConfig(Config config, int page, int limit) {
        List<Config> data = configService.listConfig(config, page, limit);
        int count = configService.countConfig(config);
        return new Result(data, count);
    }

    @PostMapping("/config")
    public boolean saveConfig(Config config) {
        return configService.saveConfig(config);
    }

    @DeleteMapping("/config/{id}")
    public boolean deleteConfig(@PathVariable Integer id) {
        return configService.deleteConfig(id);
    }

    @DeleteMapping("/configs")
    public boolean batchDeleteConfig(@RequestParam(value = "ids[]", required = false) Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        return configService.batchDeleteConfig(ids);
    }

    @PutMapping("/config")
    public boolean updateConfig(Config config) {
        return configService.updateConfig(config);
    }
}
