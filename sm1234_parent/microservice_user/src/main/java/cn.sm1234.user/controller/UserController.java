package cn.sm1234.user.controller;

import cn.sm1234.user.pojo.User;
import cn.sm1234.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(description = "user core controller")
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(method=RequestMethod.GET)
    @ApiOperation(value="find all users")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping(value="/{id}")
    @ApiOperation(value="find user by id")
    public User findById(@PathVariable Integer id){
        log.info("entering find by id method");
        System.out.println("user microservice 2222");
        return userService.findById(id);
    }
    //使用requestbody将json格式的文件转换成对象
    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value="add a new user")
    public String add(@RequestBody User user){
        userService.add(user);
        return "success";
    }
    @PutMapping(value="/{id}")
    @ApiOperation(value="update a user")
    public String update(@RequestBody User user, @PathVariable Integer id){
        //设置id
        user.setId(id);
        //user有了正确ID
        //update
        userService.update(user);
        return "update success";
    }
    @DeleteMapping(value="/{id}")
    @ApiOperation(value="delete user by id")
    public String deleteById(@PathVariable  Integer id){
        userService.delete(id);
        return "delete success";
    }
}
