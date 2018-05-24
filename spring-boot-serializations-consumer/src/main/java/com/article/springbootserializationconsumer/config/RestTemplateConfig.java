package com.article.springbootserializationconsumer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final ProtobufHttpMessageConverter protobufHttpMessageConverter;

    @Bean
    RestTemplate protoRestTemplate() {
        return new RestTemplate(Collections.singletonList(protobufHttpMessageConverter));
    }

    @Bean
    RestTemplate defaultRestTemplate() {
        return new RestTemplate();
    }
}
