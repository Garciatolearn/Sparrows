import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.sparrow.common.http.ErrorCode;
import org.sparrow.common.user.filter.CORSFilter;
import org.sparrow.common.user.filter.UserTokenFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class CommonConfiguration {

    @ConditionalOnProperty(prefix = "web-filter",name = "UserLoginFilter",havingValue = "true")
    @Bean
    public FilterRegistrationBean<UserTokenFilter> userTokenFilterRegistrationBean(){
        FilterRegistrationBean<UserTokenFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        Map<String,String> ssMap = new HashMap<>();
        ssMap.put("code", ErrorCode.CLIENT_AUTHORIZED_ERROR.getCode());
        ssMap.put("message",ErrorCode.CLIENT_AUTHORIZED_ERROR.getMessage());
        filterRegistrationBean.setFilter(new UserTokenFilter(JSON.toJSONString(ssMap)));
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(100);
        log.info("当前部署模式: 单机, userLoginFilter init finish");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<CORSFilter> CORSFilterFilterRegistrationBean(){
        FilterRegistrationBean<CORSFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setOrder(101);
        filterRegistrationBean.setFilter(new CORSFilter());
        return filterRegistrationBean;
    }

}
