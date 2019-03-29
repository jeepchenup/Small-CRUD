package info.chen.smallcrud.controller;

import info.chen.smallcrud.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class LoginController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    public static final String pwd = "admin";

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String errorInfo = null;

        if(!StringUtils.isEmpty(username) && pwd.equals(password)) {
            logger.info("Login successful!");

            session.setAttribute("username", username);
            session.setMaxInactiveInterval(60 * 30);
            return "redirect:/home";
        }
        logger.info("Do not match password.");

        Locale locale = RequestUtils.getLocale(request);
        redirectAttributes.addFlashAttribute("errorInfo", messageSource.getMessage("login.passwordInvalid", null, locale));
        return "redirect:/index";
    }
}
