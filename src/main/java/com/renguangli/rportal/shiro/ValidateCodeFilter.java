package com.renguangli.rportal.shiro;

import com.renguangli.rportal.util.CreateImageCode;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCodeFilter extends AccessControlFilter {

    /**
     * 是否开启验证码支持
     */
    private boolean validateCode = false;

    /**
     * 前台提交的验证码参数名
     */
    private String validateCodeParam = "validateCodeParam";


    public void setValidateCode(boolean validateCode) {
        this.validateCode = validateCode;
    }

    public void setValidateCodeParam(String validateCodeParam) {
        this.validateCodeParam = validateCodeParam;
    }

    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
        request.setAttribute("validateCode", validateCode);

        //2、判断验证码是否禁用 或不是表单提交（允许访问）
        if (!validateCode || !"post".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        CreateImageCode validateCode = new CreateImageCode(100,37,5,10);
        request.getSession().setAttribute("code", validateCode.getCode());
        validateCode.write(response.getOutputStream());

        String validateCode = request.getParameter(validateCodeParam);

        HttpSession session = request.getSession();
        Object validateCode1 = session.getAttribute("validateCode");

        //3、此时是表单提交，验证验证码是否正确
        return JCaptcha.validateResponse(request, request.getParameter(jcaptchaParam));
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        //如果验证码失败了，存储失败key属性
        request.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, ValidateCodeException.class.getName());
        return true;
    }
}
