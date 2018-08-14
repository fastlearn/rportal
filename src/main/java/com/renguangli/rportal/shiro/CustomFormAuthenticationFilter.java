package com.renguangli.rportal.shiro;

import com.alibaba.fastjson.JSON;
import com.renguangli.rportal.pojo.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String header = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(header)) { // 判断是否为ajax访问
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JSON.toJSONString(new Result(1001, "未登录或登录已过期")));
        } else {
            // 如果发生异常，拒绝访问，访问登录页面
            return request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME) != null
                    || super.onAccessDenied(request, response);// 问发生异常，交给shiro进行登录处理
        }
        return false;
    }
}
