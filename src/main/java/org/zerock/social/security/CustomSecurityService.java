package org.zerock.social.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.social.repository.SecurityMemberRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomSecurityService implements UserDetailsService {

    private final SecurityMemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //username에 해당하는 값은 실제로는 email
        log.info("CustomSecurityService......................." + username);




        return null;
    }
}
