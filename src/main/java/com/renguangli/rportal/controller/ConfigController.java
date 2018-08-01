package com.renguangli.rportal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ConfigController
 *
 * @author renguangli 2018/8/1 16:45
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService configService;

    @Autowired
    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/system")
    public String config(String title, Model model) {
        List<Config> configs = configService.listConfig("siteName", "domain", "indexUrl");
        Map<String, Object> map = new HashMap<>();
        configs.forEach(config -> map.put(config.getName(), config.getValue()));
        model.addAttribute("title", title);
        model.addAttribute("config", map);
        return "config/system";
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
