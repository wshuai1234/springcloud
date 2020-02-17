package cn.sm1234.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

//自定义错误类型的zuul过滤器
//@Component
public class MyErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("entering myerror filter");
        //异常处理？
        //捕获异常信息
        //把异常信息以json格式给前端
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse response = currentContext.getResponse();
        ZuulException exception = (ZuulException)currentContext.get("throwable");
        //json output
        Result result = new Result(false,"execute failed" + exception.getMessage());
        //transfer to json
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String jsonString = objectMapper.writeValueAsString(result);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }catch(Exception e){
            e.printStackTrace();;
        }
        return null;
    }
}
