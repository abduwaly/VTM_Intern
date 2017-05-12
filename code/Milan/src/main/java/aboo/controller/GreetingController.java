package aboo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/5/4.
 */
@Controller
@RequestMapping("/greeting")
public class GreetingController {

    private Logger log = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping(value= "/say",method=RequestMethod.GET)
    public String say(HttpServletRequest request, HttpServletResponse response){

        request.setAttribute("name","Aboo");

        //测试logger
        log.debug("-----------打出这一行说明：我的logback会用了！！！----------------");

        return "hello";
    }

    @RequestMapping(value= "/say/{proId}",method=RequestMethod.GET)
    public String rest(@PathVariable String proId,HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("name",proId);

        //测试logger
        log.debug("传过来的proId:"+proId);

        return "hello";
    }



}


