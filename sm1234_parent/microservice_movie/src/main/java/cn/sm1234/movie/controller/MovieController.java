package cn.sm1234.movie.controller;
import cn.sm1234.movie.client.UserController;
import cn.sm1234.movie.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/movie")
@RestController
@Api(description = "movie core api")
public class MovieController {
//    @Autowired
//    private RestTemplate restTemplate;
//    @PostMapping("/order")
//    public String order(){
//        //模拟读取当前用户
//        Integer id = 2;
//        //查询用户微服务获取用户信息
//        //url address-> encapsulate object
//        User user = restTemplate.getForObject("http://localhost:9001/user/" + id, User.class);
//        System.out.println(user + "===" + "ordering...");
//        return "order success";
//    }
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @GetMapping("/order")
//    public String order(){
//        //模拟读取当前用户
//        Integer id = 2;
//        //到eureka里发现用户微服务
//        //返回值为什么是list? 可以注册相同名字的service,获取所有同名微服务
//        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user"); //参数：需要发现的微服务名称
//        //没有负载均衡时 现用第一个
//        ServiceInstance serviceInstance = instances.get(0);
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id,User.class);
//        System.out.println(user + "===" + "ordering...");
//        return "order success";
//    }


    //购票方法，使用ribbon 负载均衡
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    @GetMapping("/order")
//    public String order(){
//        //模拟读取当前用户
//        Integer id = 1;
//        //使用ribbon帮助选择合适的服务实例
//        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-user");
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id,User.class);
//        System.out.println(user + "===" + "ordering...");
//        return "order success";
//    }


    //简化版ribbon
//    @GetMapping("/order")
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String order(){
//        //模拟读取当前用户
//        Integer id = 1;
//        User user = restTemplate.getForObject("http://microservice-user/user/" + id,User.class);
//        System.out.println(user + "===" + "ordering...");
//        return "order success";
//    }
//    //熔断器fallback方法
//    public String fallback(){
//        return "service temporal unavailable";
//    }

    private static final Log log = LogFactory.getLog(MovieController.class);
    //使用openfeign
    @Autowired
    private UserController userController;
    @ApiOperation(value = "remote search user by userId")
    @GetMapping("/order")
    public String order(){
        log.info("start to call order method");
        //模拟读取当前用户
        Integer id = 1;
        User user = userController.findById(id);
        System.out.println(user+"==ordering");
        return "order success";

    }
}
