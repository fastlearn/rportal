package com.renguangli.rportal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> listConfig(Config config) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("count", 5);
        result.put("msg", "获取配置信息成功");
        result.put("data", configService.listConfig(config));
        return result;
    }

    @ResponseBody
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
