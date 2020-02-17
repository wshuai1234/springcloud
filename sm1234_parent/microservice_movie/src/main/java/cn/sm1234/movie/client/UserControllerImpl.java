package cn.sm1234.movie.client;

import cn.sm1234.movie.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements  UserController{
    @Override
    public User findById(Integer id) {
        System.out.println("execute hystrix");
        return null;
    }
}
