package com.renguangli.rportal.shiro;

import com.alibaba.fastjson.JSON;
import com.renguangli.rportal.pojo.Result;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    public CustomPermissionsAuthorizationFilter() {}

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        if (!StringUtils.isEmpty(requestedWith) &&
                "XMLHttpRequest".equals(requestedWith)) {//如果是ajax返回指定格式数据
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(JSON.toJSONString(new Result(403, "权限不足")));
        } else {//如果是普通请求进行重定向
            return super.onAccessDenied(httpServletRequest, httpServletResponse);
        }
        return false;
    }
}
