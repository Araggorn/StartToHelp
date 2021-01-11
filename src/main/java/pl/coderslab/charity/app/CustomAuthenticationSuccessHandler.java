package pl.coderslab.charity.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.coderslab.charity.service.SingleUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private SingleUserService usersService;

    @Autowired
    public void setUsersService(SingleUserService userService) {
        this.usersService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Long userId = usersService.findUserIdByEmail(SecurityUtils.username());
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin/profile");
        } else {
            httpServletResponse.sendRedirect("/profile");
        }

//        if (!isAdminAuthority(authentication)) {
//            String targetUrl = super.determineTargetUrl(request, response);
//            if (StringUtils.(targetUrl) || StringUtils.equals(targetUrl, "/")) {
//                targetUrl = "/profile";
//            }
//            clearAuthenticationAttributes(request);
//            LOG.info("Redirecting customer to the following location {} ", targetUrl);
//            redirectStrategy.sendRedirect(request, response, targetUrl);
//        } else {
//            redirectStrategy.sendRedirect(request, response, "/admin/profile");        }
//
//        clearAuthenticationAttributes(request);
//    }
//
//    protected boolean isAdminAuthority(final Authentication authentication)
//    {
//        return CollectionUtils.isNotEmpty(authentication.getAuthorities())
//                && authentication.getAuthorities().contains(adminAuthority);
//    }
    }
}
