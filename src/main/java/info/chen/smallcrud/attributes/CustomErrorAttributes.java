package info.chen.smallcrud.attributes;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map =  super.getErrorAttributes(webRequest, includeStackTrace);

        map.put("extension", webRequest.getAttribute("extension", RequestAttributes.SCOPE_REQUEST));
        return map;
    }
}
