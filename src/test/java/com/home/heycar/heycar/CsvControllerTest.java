package com.home.heycar.heycar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.home.heycar.HeycarApplication;

@SpringBootTest(classes = HeycarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CsvControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void givenUploadForm_whenRequestWithMultipartData_thenSuccess() throws Exception {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", new ClassPathResource("/test.csv"))
                .contentType(MediaType.MULTIPART_FORM_DATA);
        client.post()
                .uri(uriBuilder -> uriBuilder.path("/v1/upload_csv")
                        .queryParam("dealerId", "hello")
                        .build())
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(multipartBodyBuilder.build()))
                .exchange()
                .expectStatus()
                .isOk();
    }
}
