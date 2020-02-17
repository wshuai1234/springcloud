package cn.sm1234.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//hystrix dashboard引导类
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixApplication {
    public static void main(String[] args){
        SpringApplication.run(HystrixApplication.class, args);
    }
}
