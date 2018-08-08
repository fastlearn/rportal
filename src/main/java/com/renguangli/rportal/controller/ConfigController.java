package com.renguangli.rportal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.bean.Result;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<Config> data = configService.listConfig(config, page - 1, limit);
        int count = configService.countConfig(config);
        return new Result(data, count);
    }

    @DeleteMapping("/config/{id}")
    public boolean deleteConfig(@PathVariable String id) {
        return configService.deleteConfig(id);
    }

    @DeleteMapping("/configs")
    public boolean batchDeleteConfig(@RequestParam(value = "ids[]", required = false) Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        return configService.batchDeleteConfig(ids);
    }

    @PostMapping("/system")
    public boolean updateConfig(String params) {
        if (StringUtils.isEmpty(params)) {
            return false;
        }
        JSONObject jsonObject = JSON.parseObject(params);
        ArrayList<Config> configs = new ArrayList<>();
        jsonObject.forEach((key, value) -> configs.add(new Config(key, value.toString())));
        return configService.updateConfig(configs);
    }
}
