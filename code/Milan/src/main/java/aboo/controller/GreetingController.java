package aboo.controller;

import aboo.bean.User;
import aboo.entity.Dog;
import aboo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by admin on 2017/5/4.
 */
@Controller
@Api(value = "打招呼的一个Controller")
@RequestMapping("/greeting")
public class GreetingController {

    private Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    UserService us;

    @ApiOperation(value = "打招呼")
    @RequestMapping(value= "/say",method=RequestMethod.GET)
    public String say(HttpServletRequest request, HttpServletResponse response){

        request.setAttribute("name","Aboo");

        //测试logger
        log.debug("-----------打出这一行说明：我的logback会用了！！！----------------");

        return "hello";
    }

    @ApiOperation(value = "通过url来传参")
    @RequestMapping(value= "/say/{name}",method=RequestMethod.GET)
    public String rest(@PathVariable String name,HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("name",name);

        //测试logger
        log.debug("传过来的name:"+name);

        return "hello";
    }

    /**
     * //@Valid 是hibernate validation验证用的
     * //@Validate 是Spring Validater验证用的
     *
     * Validation_Test
     *
     * Dog{id (not null),age (min:2 & max:10)}
     *
     * @param dog
     * @return
     */
    @ApiOperation(value = "添加一个")
    @ResponseBody
    @RequestMapping(value = "/add_dog",method = RequestMethod.POST)
    public Dog add_dog(@Valid @RequestBody Dog dog){
        log.debug(dog.toString());
        return dog;
    }

    //test integration
    @ApiOperation(value = "添加用户来测试整合是否成功")
    @ResponseBody
    @RequestMapping(value = "/camp",method = RequestMethod.GET)
    public User new_account(){

        User u = us.create_account("7777","samuel");
        log.debug("添加了一个账户："+u);

        return u;
    }


}


