package me.liliput.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UrlPathHelper;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Configuration
public class WebConfig {

    @Bean
    public UrlPathHelper urlPathHelper(){
        return  new UrlPathHelper();
    }
}
