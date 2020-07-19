package org.zerock.social.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.zerock.social.security.CustomOAuth2User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
public class CustomOAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.info("onAuthenticationSuccess...................................................................................");
        log.info(authentication);
        log.info("onAuthenticationSuccess...................................................................................");

        try{

            CustomOAuth2User userInfo = (CustomOAuth2User)authentication.getPrincipal();

            if(userInfo.isCheckExist()){
                super.onAuthenticationSuccess(request,response,authentication);
                return;
            }

            response.sendRedirect("/member/plus");

        }catch(Exception e){

        }


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
