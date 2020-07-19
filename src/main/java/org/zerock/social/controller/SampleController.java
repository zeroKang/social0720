package org.zerock.social.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/all")
    public void all(){

        log.info("GET /sample/all...............");

    }

    @GetMapping("/mypage")
    public void getMypage(){

        log.info("GET /sample/mypage...............");

    }

}
