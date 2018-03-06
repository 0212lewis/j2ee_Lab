package cn.edu.nju.p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
public class SwaggerController {

    @RequestMapping("/api")
    public String redirect() {
        return "redirect:swagger-ui.html";
    }
}
