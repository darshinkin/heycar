package com.home.heycar.heycar.handlers;

/*import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.fromResource;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.home.heycar.HeycarApplication;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(classes = HeycarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UploadHandlerTest {

    private static final String BODY_VALUE = "bodyValue";

    @LocalServerPort
    private int port;

    @Test
    public void givenUploadForm_whenRequestWithMultipartData_thenSuccess() throws Exception {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
        Resource resource = new ClassPathResource("/test.csv");
        client.post()
                .uri("/upload")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(fromResource(resource))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo(String.valueOf(resource.contentLength()));
    }

    @Test
    void testRestUploadCsvReturnDefaulMessage() {
        // WebClient creation
        WebClient client1 = WebClient.create();
        // response assertions
        StepVerifier.create(retrieveResponse(client1.post()
                .uri("http://localhost:" + port + "/v1/upload_csv")))
                .expectNext("{\"message\":\"default\"}")
                .verifyComplete();
    }

    @Test
    void testRestUploadCsv() {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
        // WebClient creation
        WebClient client1 = WebClient.builder()
                .baseUrl("http://localhost:" + port + "/v1/upload_csv")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
                .build();
        // response assertions
        StepVerifier.create(retrieveResponse(client1.post()
                .uri("http://localhost:" + port + "/v1/upload_csv")))
                .expectNext("{\"message\":\"default\"}")
                .verifyComplete();
    }

    @Test
    void upload() {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("files", new ClassPathResource("test.csv")).contentType(MULTIPART_FORM_DATA);
        client.post()
                .uri("/v1/upload_csv")
                .accept(ALL)
                .contentType(MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class);
    }

    private Mono<String> retrieveResponse(WebClient.RequestBodySpec spec) {
        return spec.bodyValue(BODY_VALUE)
                .retrieve()
                .bodyToMono(String.class);
    }
}*/
