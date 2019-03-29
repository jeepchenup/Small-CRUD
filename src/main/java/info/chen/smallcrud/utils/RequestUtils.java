package info.chen.smallcrud.utils;

import info.chen.smallcrud.constant.CommonConstants;
import info.chen.smallcrud.constant.RequestContants;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Optional;

public class RequestUtils {

    public static Locale getLocale(HttpServletRequest request) {
        Optional<String> lang = Optional.ofNullable(request.getParameter(RequestContants.language));

        try {
            String[] langInfo = lang.get().split(CommonConstants.underline);
            return new Locale(langInfo[0], langInfo[1]);
        } catch (Exception e) {
        }
        return Locale.getDefault();
    }

    public static ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(RequestContants.message_basename);
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setCacheSeconds(0);

        return messageSource;
    }
}
