package com.renguangli.rportal.shiro;

import com.renguangli.rportal.RportalApplication;
import com.renguangli.rportal.bean.Config;
import com.renguangli.rportal.mapper.ConfigMapper;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ValidateCodeFilter extends AccessControlFilter {

    /**
     * 是否开启验证码支持
     */
    private String validateCodeEnabled = "false";

    /**
     * 前台提交的验证码参数名
     */
    private String validateCodeParam = "validateCode";

    public void setValidateCodeEnabled(String validateCodeEnabled) {
        this.validateCodeEnabled = validateCodeEnabled;
    }

    public void setValidateCodeParam(String validateCodeParam) {
        this.validateCodeParam = validateCodeParam;
    }

    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        ConfigMapper configMapper = RportalApplication.ctx.getBean("configMapper", ConfigMapper.class);
        Config config = configMapper.getConfig("validateCodeEnabled");
        if (!StringUtils.isEmpty(config)) {
            validateCodeEnabled = config.getValue();
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
        request.setAttribute("validateCodeEnabled", validateCodeEnabled);

        // 2、判断验证码是否禁用 或不是表单提交（允许访问）
        if (!"true".equals(validateCodeEnabled) || !"post".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 3、此时是表单提交，验证验证码是否正确
        String code = request.getParameter(validateCodeParam);//页面输入的验证码
        Object validateCode = request.getSession().getAttribute(validateCodeParam);
        if(code == null) {
            return false;
        } else if (validateCode != null) {
            return code.toLowerCase().equals(validateCode.toString().toLowerCase());
        }
        return true;
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        //如果验证码失败了，存储失败key属性
        request.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, ValidateCodeException.class.getName());
        return true;
    }
}
