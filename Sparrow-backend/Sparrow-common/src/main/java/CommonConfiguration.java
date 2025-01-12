import lombok.extern.slf4j.Slf4j;
import org.sparrow.common.user.filter.UserTokenFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CommonConfiguration {

    @ConditionalOnProperty(prefix = "web-filter",name = "UserLoginFilter",havingValue = "true")
    @Bean
    public FilterRegistrationBean<UserTokenFilter> userTokenFilterRegistrationBean(){
        FilterRegistrationBean<UserTokenFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new UserTokenFilter());
        filterRegistrationBean.addUrlPatterns("/**");
        filterRegistrationBean.setOrder(100);
        log.info("当前部署模式: 单机, userLoginFilter init finish");
        return filterRegistrationBean;
    }

}
