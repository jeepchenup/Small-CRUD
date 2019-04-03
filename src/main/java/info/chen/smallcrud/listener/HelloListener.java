package info.chen.smallcrud.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(HelloListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        logger.info(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Hello Listener has been destroyed.");
    }
}
