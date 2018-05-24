package com.article.springbootserializationconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(value = "app.config")
@Data
@Component
public class ProducerPropertiesConfiguration {
    private String producerProtobufUrl;
    private String producerJsonUrl;
}
