package org.zerock.social.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.zerock.social.entity.SecurityMember;
import org.zerock.social.repository.SecurityMemberRepository;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomOAuthSecurityService extends DefaultOAuth2UserService {

    private final SecurityMemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User  auth2User =  super.loadUser(userRequest);

        log.info("----------------------------------------");
        log.info(auth2User);

        log.info(userRequest.getAdditionalParameters());

        String email  = auth2User.getAttribute("email");


        log.info("email..................." + email);


        Optional<SecurityMember> result = memberRepository.findById(email);

        boolean checkLocal = false;

        if(result.isPresent()){
            checkLocal = true;
        }

        return new CustomOAuth2User(auth2User, checkLocal);
    }
}
