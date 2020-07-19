package org.zerock.social;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class BcryptTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {

        String str = "1111";

        String enStr = passwordEncoder.encode(str);

        //$2a$10$suvYAqYDPnLqvfHcTfU57eTJ.kiYmAluCnvgbbOsjxOH9voQjQMj2
        //$2a$10$kLP0ihXYmzDqb1C0a6z1reEEvG3R/2PBQNVgdnTBf2gdqXD1o.yK2
        System.out.println(enStr);

    }
}
