package com.home.heycar.config;

import java.nio.file.Paths;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.home.heycar.properties.StorageProperties;
import com.home.heycar.services.FileSystemStorageService;

@Configuration
public class HeycarConfig {

    @Bean
    FileSystemStorageService fileSystemStorageService() {
        return new FileSystemStorageService(Paths.get(storageProperties().getLocation()));
    }

    @Bean
    @ConfigurationProperties(prefix = "storage")
    public StorageProperties storageProperties() {
        return new StorageProperties();
    }
}
