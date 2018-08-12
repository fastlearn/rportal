package com.renguangli.rportal.shiro;

import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 扩展AdviceFilter，用于ajax访问接口未登录的处理
 */
public class CustomAdviceFilter extends AdviceFilter {

    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     * @param request request
     * @param response response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws  Exception Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

      /*  if (StringUtils.isNotEmpty(requestedWith) && StringUtils.equals(requestedWith, "XMLHttpRequest")) {//如果是ajax返回指定数据
            ResponseHeader responseHeader = new ResponseHeader();
            responseHeader.setResponse(ResponseHeader.SC_MOVED_TEMPORARILY, null);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            response.getWriter().write(JSONObject.toJSONString(responseHeader));
            return false;
        }*/
        return super.preHandle(request, response);
    }
}
