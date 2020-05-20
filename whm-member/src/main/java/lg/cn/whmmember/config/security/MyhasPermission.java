package lg.cn.whmmember.config.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyhasPermission {
    ObjectMapper objectMapper = new ObjectMapper();
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(Authentication authentication, HttpServletRequest request) throws JsonProcessingException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            System.out.println(objectMapper.writeValueAsString(userDetails));
            return userDetails.getAuthorities()
                    .stream()
                    .anyMatch(o -> antPathMatcher.match(((GrantedAuthority) o).getAuthority(), requestURI));
        }
        return false;
    }

}
