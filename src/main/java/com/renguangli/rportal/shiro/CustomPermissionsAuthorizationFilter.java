package com.renguangli.rportal.shiro;

import com.alibaba.fastjson.JSON;
import com.renguangli.rportal.pojo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重写perms过滤器，支持ajax
 */
public class CustomPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    public CustomPermissionsAuthorizationFilter() {}

    /**
     * Handles the response when access has been denied.  It behaves as follows:
     * <ul>
     * <li>If the {@code Subject} is unknown<sup><a href="#known">[1]</a></sup>:
     * <ol><li>The incoming request will be saved and they will be redirected to the login page for authentication
     * (via the {@link #saveRequestAndRedirectToLogin(javax.servlet.ServletRequest, javax.servlet.ServletResponse)}
     * method).</li>
     * <li>Once successfully authenticated, they will be redirected back to the originally attempted page.</li></ol>
     * </li>
     * <li>If the Subject is known:</li>
     * <ol>
     * <li>The HTTP {@link HttpServletResponse#SC_UNAUTHORIZED} header will be set (401 Unauthorized)</li>
     * <li>If the {@link #getUnauthorizedUrl() unauthorizedUrl} has been configured, a redirect will be issued to that
     * URL.  Otherwise the 401 response is rendered normally</li>
     * </ul>
     * <code><a name="known">[1]</a></code>: A {@code Subject} is 'known' when
     * <code>subject.{@link org.apache.shiro.subject.Subject#getPrincipal() getPrincipal()}</code> is not {@code null},
     * which implicitly means that the subject is either currently authenticated or they have been remembered via
     * 'remember me' services.
     *
     * @param request  the incoming <code>ServletRequest</code>
     * @param response the outgoing <code>ServletResponse</code>
     * @return {@code false} always for this implementation.
     * @throws IOException if there is any servlet error.
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String header = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(header)) { // 判断是否为ajax访问
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JSON.toJSONString(new Result(1003, "权限不足")));
        } else {
            return super.onAccessDenied(request, response);
        }
        return false;
    }
}
