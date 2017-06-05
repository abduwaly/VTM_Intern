package aboo.controller;

import aboo.entity.User;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by admin on 2017/5/5.
 */
@Controller
@Api(value = "用户的Controller")
@RequestMapping("/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    static Map map = new HashMap<String,User>();

    static {
        map.put("1",new User("1","aaa","123","vtm","123456789","aaa@xx.com","000000"));
        map.put("2",new User("2","bbb","456","prd","123456789","bbb@xx.com","000000"));

//        log.debug("初始化完成，map里存了两个User");
    }

    /**
     * find User by empNo
     * 查询
     * @param empNo
     * @return
     */

    @ResponseBody
    @ApiOperation(value = "查看用户",notes = "根据url的empNo查看用户")
    @RequestMapping(value="/find/{empNo}",method= RequestMethod.GET)
    public User find(@PathVariable String empNo) {

        log.debug("查看empNo="+empNo+"的用户");
        return (User) map.get(empNo);
    }

    /**
     * return all Users
     * 查看
     * @return
     */
    @ResponseBody
    @ApiOperation(value="查看所有用户")
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public Map users() {

        log.debug("所有User： "+map.toString());
        return map;
    }

    /**
     * add a User
     * 添加
     * @param user
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map add(@RequestBody User user){

        log.debug("新添加的User："+user.toString());
        map.put(user.getEmpNo(),user);
        return users();
    }

    /**
     * delete by empNo
     * 删除
     * @param empNo
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "删除用户",notes = "根据url的empNo删除用户")
    @RequestMapping(value = "/delete/{empNo}",method = RequestMethod.DELETE)
    public Map delete(@PathVariable String empNo) {


        log.debug("删除empNO="+empNo+"的User");
        map.remove(empNo);
        return users();
    }

    /**
     * update User's information
     * 修改
     * @param user
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "修改用户信息",notes="覆盖用户原数据中被修改了的信息")
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Map update(@RequestBody User user){

        if(map.containsKey(user.getEmpNo())){
            map.put(user.getEmpNo(),user);
            log.debug("成功更新了empNo="+user.getEmpNo()+"的User信息 ---> "+user);
        }
        return users();
    }



}
