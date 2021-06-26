package com.home.heycar.routers;

/*import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.home.heycar.config.ListingConfig;
import com.home.heycar.handlers.ProductHandlers;
import com.home.heycar.services.ListingService;

@Configuration
@Import(value = {ListingConfig.class})
public class Routers {

    @Value("${app.api.endpoint.listing.upload.csv}")
    private String uriPostUploadCsv;

    @Value("${app.api.endpoint.listing.upload.json}")
    private String uriPostUploadJson;

    @Autowired
    private ListingService listingService;

    @Bean
    public RouterFunction<ServerResponse> productRouter() {
        RequestPredicate listingUploadCsv = RequestPredicates.POST(this.uriPostUploadCsv)
                .and(RequestPredicates.accept(MediaType.MULTIPART_FORM_DATA));
        RequestPredicate listingUploadJson = POST(this.uriPostUploadJson);
        return RouterFunctions
                .route(listingUploadCsv, productHandlers()::listingUploadCsv)
                .andRoute(listingUploadJson, productHandlers()::listingUploadJson)
                .andRoute(POST("/upload"), productHandlers()::handleUpload);
    }

    @Bean
    public ProductHandlers productHandlers() {
        return new ProductHandlers(listingService);
    }
}*/
