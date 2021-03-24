package com.github.fabriciolfj.imagetodropbox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "dropbox")
public class ImageToDropboxProperties {

    private String apiKey = "rc57twkr0nyj5vk";
    private String path = "/IMDB/";
    private String localTmpFolder = "/c/fotos/";
}
