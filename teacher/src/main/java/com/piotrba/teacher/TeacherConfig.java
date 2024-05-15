package com.piotrba.teacher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TeacherConfig {

    @Bean
    public RestTemplate restTemplate() {return new RestTemplate(); }
}
