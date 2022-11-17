package com.biqi.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@Api(tags = {"The page jumps to the API documentation"})
public class PageConstantController {



    @RequestMapping("/403")
    public String unauthorizedRole(){

        return "403";
    }



    @RequestMapping("/404")
    public String unfind(){

        return "404";
    }

}
