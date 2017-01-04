package me.liliput.api;

import me.liliput.api.controller.filter.CORSFilter;
import me.liliput.api.util.builder.PathBuilder;
import org.springframework.beans.factory.annotation.Value;
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

    @Bean
    public PathBuilder pathBuilder() { return new PathBuilder(); }

    @Bean
    public CORSFilter corsFilter(@Value("${dashboard.url}") String dashboardUrl) {
        return new CORSFilter(dashboardUrl);
    }
}
