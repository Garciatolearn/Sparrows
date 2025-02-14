package org.sparrow.common.user.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "web-filter")
@Component
@Data
public class UserTokenFilterProperties {

    private boolean UserLoginFilter = true;
}
