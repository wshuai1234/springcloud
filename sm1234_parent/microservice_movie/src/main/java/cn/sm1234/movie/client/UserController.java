package cn.sm1234.movie.client;

import cn.sm1234.movie.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//用户微服务的远程接口
//使用FeignClinet注解,声明需要调用的微服务
//检查@RequestMapping注解，value是否complete
//pathvariable注解的value值不能省略
@FeignClient(value="microservice-user", fallback = UserControllerImpl.class)
public interface UserController {

    @GetMapping(value="/user/{id}")
    public User findById(@PathVariable(value="id") Integer id);
}
