package org.zerock.social.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class SocialController {


    @GetMapping("/member/plus")
    public void plusJoin(){

        log.info("/member/plus................");

    }


}
