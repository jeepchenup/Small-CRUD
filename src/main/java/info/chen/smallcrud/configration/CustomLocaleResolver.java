package info.chen.smallcrud.configration;

import info.chen.smallcrud.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class CustomLocaleResolver implements LocaleResolver {

    private static final Logger logger = LoggerFactory.getLogger(CustomLocaleResolver.class);

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        return RequestUtils.getLocale(request);
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
