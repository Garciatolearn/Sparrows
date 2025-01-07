import lombok.extern.slf4j.Slf4j;
import org.sparrow.common.user.filter.UserTokenFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class CommonConfiguration {

    @ConditionalOnProperty(prefix = "web-filter",name = "UserLoginFilter",havingValue = "true")
    @Bean
    public FilterRegistrationBean<UserTokenFilter> userTokenFilterRegistrationBean(){
        FilterRegistrationBean<UserTokenFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new UserTokenFilter());
        filterRegistrationBean.addUrlPatterns("/**");
        filterRegistrationBean.setOrder(100);
        return filterRegistrationBean;
    }

}
