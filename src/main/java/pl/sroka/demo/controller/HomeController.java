package pl.sroka.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


// just trying to remind
@Controller
@ResponseBody
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ind(){
        return "ind";
    }
}
