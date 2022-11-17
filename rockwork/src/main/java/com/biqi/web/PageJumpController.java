package com.biqi.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@Api(tags = {"The page jumps to the API documentation\n"})
public class PageJumpController {

    @RequestMapping("/index")
    public String index(){
        return "login";
    }


    @RequestMapping("/main")
    public String main(){
        return"/main";
    }


    @RequestMapping("/login")
    public String login(){
        return"/login";
    }






}
