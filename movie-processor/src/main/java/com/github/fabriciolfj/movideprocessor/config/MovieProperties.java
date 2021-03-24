package com.github.fabriciolfj.movideprocessor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "movie")
public class MovieProperties {

    String apiServer;
    String headerHost;
    String headerKey;
}
