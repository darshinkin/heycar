package com.home.heycar.config;

import com.home.heycar.persistence.dao.ListingDao;
import com.home.heycar.persistence.repositories.ListingRepository;
import com.home.heycar.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListingConfig {

    @Autowired
    private ListingRepository listingRepository;

    @Bean
    public ListingService productService() {
        return new ListingService(productDao());
    }

    @Bean
    public ListingDao productDao() {
        return new ListingDao(listingRepository);
    }
}
