package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
public class FindDateController {


    // Notice here that since the class has "/demo", this path is "/demo/page"
    @RequestMapping("/bookDate")
    public String goToWebsite() {
        return "FindDate"; 
    }


}
