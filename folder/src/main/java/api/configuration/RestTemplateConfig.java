package api.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration to initialize the RestTemplate-Bean which is used to make REST-calls to other APIs
 * Also see: https://stackoverflow.com/questions/42365266/call-another-rest-api-from-my-server-in-spring-boot
 * 
 * @author Dennis
 *
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
}