package info.chen.smallcrud.configration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CustomLocaleResolver implements LocaleResolver {

    private static final String language = "language";

    private static final Logger logger = LoggerFactory.getLogger(CustomLocaleResolver.class);

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Optional<String> localeStr = Optional.ofNullable(request.getParameter(language));
        Locale locale = null;
        try {
            String[] localeInfo = localeStr.get().split("_");
            locale = new Locale(localeInfo[0], localeInfo[1]);
            logger.info("Get Custom locale language :{}", localeStr.get());
        } catch (NoSuchElementException e) {
            logger.warn("There is no language parameter in request.", e);
            locale = Locale.getDefault();
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
