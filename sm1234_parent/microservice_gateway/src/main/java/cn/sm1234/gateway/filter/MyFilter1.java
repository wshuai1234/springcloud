package cn.sm1234.gateway.filter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
// first zuul filter
//@Component
public class MyFilter1 extends ZuulFilter {
    // pre post error routing
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    // low value -> high priority
    @Override
    public int filterOrder() {
        return 1;
    }
    // 是否让过滤器生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("inside myfilter1");
        return null;
    }
}
