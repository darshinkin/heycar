package com.home.heycar.handlers;

/*import static org.springframework.web.reactive.function.BodyExtractors.toDataBuffers;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.home.heycar.messages.Message;
import com.home.heycar.messages.Response;
import com.home.heycar.persistence.models.Listing;
import com.home.heycar.services.ListingService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductHandlers {

    public static final String PATH_VARIABLE_ID = "id";
    public static final String PATH_VARIABLE_DEALER_ID = "dealer_id";
    private final ListingService listingService;

    public Mono<ServerResponse> listingUploadCsv(ServerRequest serverRequest) {
        Optional<String> dealerId = serverRequest.queryParam(PATH_VARIABLE_DEALER_ID);
        Mono<Response> responseMessageMono = Mono.just(Response.builder()
                .messages(List.of(Message.builder().message(dealerId.orElse("default")).build())).build());
//        Mono<Product> productMono = productService.retrieveProductById(Long.parseLong(productId));
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMessageMono, Listing.class)
                .switchIfEmpty(ServerResponse.notFound().build());
//        return null;
    }

    public Mono<ServerResponse> listingUploadJson(ServerRequest serverRequest) {
        *//*return serverRequest.bodyToMono(ProductCreateRequest.class)
                .flatMap(productCreateRequest -> {
                    Mono<Product> productMono = listingService.save(Product.builder()
                            .productName(productCreateRequest.getProductName())
                            .build());
                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(productMono, Product.class);
                });*//*
        return null;
    }

    public Mono<ServerResponse> handleUpload(ServerRequest request) {
        return request.body(toDataBuffers())
                .collectList()
                .flatMap(dataBuffers -> ok().body(fromValue(extractData(dataBuffers).toString())));
    }

    private AtomicLong extractData(List<DataBuffer> dataBuffers) {
        AtomicLong atomicLong = new AtomicLong(0);
        dataBuffers.forEach(d -> atomicLong.addAndGet(d.readableByteCount()));
        return atomicLong;
    }
}*/
