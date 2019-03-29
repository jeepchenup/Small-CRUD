package info.chen.smallcrud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLogger {

    Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Test
    public void test() {
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

    @Test
    public void testEmpty() {
        assertNotNull(messageSource);

        logger.info(messageSource.getClass().getName());

//        ResourceBundleMessageSource resourceBundleMessageSource = (ResourceBundleMessageSource) messageSource;

        String value = messageSource.getMessage("login.tip", null, Locale.CHINA);

        System.out.println(value);
    }

    @Test
    public void testLocale() {
        System.out.println(Locale.getDefault().toString());
    }
}
