package org.zerock.social.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.social.entity.SecurityMember;
import org.zerock.social.entity.MemberRole;

import java.util.stream.IntStream;

@SpringBootTest
public class SecurityMemberRepositoryTests {

    @Autowired
    private SecurityMemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers() {

        IntStream.rangeClosed(1,100).forEach(i -> {

            SecurityMember member = SecurityMember.builder()
                    .email("user"+i+"@aaa.com")
                    .password(passwordEncoder.encode("user"+i))
                    .name("USER"+i)
                    .build();

            member.addMemberRole(MemberRole.USER);

            if(i >= 80){
                member.addMemberRole(MemberRole.MANAGER);
            }

            if(i >=90){
                member.addMemberRole(MemberRole.ADMIN);
            }

            memberRepository.save(member);

        });
    }

    @Test
    public void insertGoogleEmail() {

        SecurityMember member = SecurityMember.builder()
                .email("zerockcode@gmail.com")
                .password(passwordEncoder.encode("1111"))
                .name("ZEROCK")
                .build();
        member.addMemberRole(MemberRole.USER);
        memberRepository.save(member);
    }


}
