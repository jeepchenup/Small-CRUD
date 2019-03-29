package info.chen.smallcrud.interceptor;

import info.chen.smallcrud.constant.RequestContants;
import info.chen.smallcrud.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!StringUtils.isEmpty(request.getSession().getAttribute("username"))) {
            return true;
        }

        logger.info("Please login first");

        ReloadableResourceBundleMessageSource messageSource = RequestUtils.getMessageSource();
        request.setAttribute("errorInfo", messageSource.getMessage("login.unloginInfo", null, RequestUtils.getLocale(request)));
        request.getRequestDispatcher("/index").forward(request, response);
        return false;
    }
}
