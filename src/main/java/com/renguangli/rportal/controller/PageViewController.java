package com.renguangli.rportal.controller;

import com.renguangli.rportal.pojo.Config;
import com.renguangli.rportal.pojo.User;
import com.renguangli.rportal.service.ConfigService;
import com.renguangli.rportal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PageViewController
 *
 * @author renguangli 2018/8/2 13:25
 * @since JDK 1.8
 */
@Controller
public class PageViewController {

    /** 存放url: view键值对 */
    private static Map<String, String> pageViews = new ConcurrentHashMap<>();

    @Resource
    private UserService userService;

    @Resource
    private ConfigService configService;

    @GetMapping("")
    public String enterFrontend() {
        return "index";
    }

    @GetMapping("/{username}")
    public String enterFrontend(@PathVariable("username") String username) {
        if ("403".equals(username)) {
            return "error/403";
        }
        User user = userService.getUser(new User(username));
        return user == null ? "error/404" : "backend/index";
    }

    @GetMapping("/pageView")
    public String enterBackend(Model model) {
        Config config = configService.getConfig(new Config("siteName"));
        model.addAttribute("siteName", config.getValue());
        return "backend/index";
    }

    @GetMapping("/pageView/{pageName}")
    public String enterBackend(@PathVariable("pageName") String pageName) {
        String view = getView(pageName);
        return view == null ? "error/404" : view;
    }

    private String getView(String pageName) {
        if (pageViews.isEmpty()) {
            //系统配置页面
            pageViews.put("config", "backend/config");
            //dashboard页面
            pageViews.put("dashboard", "backend/dashboard");
            //用户管理页面
            pageViews.put("user", "backend/user");
            //角色管理页面
            pageViews.put("role", "backend/role");
            //权限管理页面
            pageViews.put("permission", "backend/permission");
        }
        return pageViews.get(pageName);
    }


/*    @PostConstruct
    public void list() {
        List<HashMap<String, String>> urlList = new ArrayList<HashMap<String, String>>();

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String url : p.getPatterns()) {
                hashMap.put("url", url);
            }
           // hashMap.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
            //hashMap.put("method", method.getMethod().getName()); // 方法名
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            //String type = methodsCondition.toString();
            *//*if (type.startsWith("[") && type.endsWith("]")) {
                type = type.substring(1, type.length() - 1);
                hashMap.put("type", type); // 方法名
            }*//*
            urlList.add(hashMap);
        }
        System.out.println(JSON.toJSONString(urlList));
    }*/
}
