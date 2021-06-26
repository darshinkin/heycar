package com.home.heycar.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.home.heycar.messages.Message;
import com.home.heycar.messages.Response;
import com.home.heycar.services.ListingService;
import com.home.heycar.services.csv.ApacheCommonsCsvUtil;

@RestController
public class CsvController {

    private ListingService listingService;

    public CsvController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping(path = "${app.api.endpoint.listing.upload.csv}")
    public Response uploadListingCsv(@RequestParam("file") MultipartFile file,
            @RequestParam("dealerId") String dealerId) {
        Response response = new Response();
        if (dealerId == null || dealerId.isBlank()) {
            return buildResponse(file, "No selected dealer! Please do the checking", "fall");
        }
        if (Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            return buildResponse(file, "No selected file to upload! Please do the checking", "fail");
        }
        if (!ApacheCommonsCsvUtil.isCSVFile(file)) {
            return buildResponse(file, "Error: this is not a CSV file!", "fail");
        }
        try {
            listingService.store(file.getInputStream(), dealerId);
            return buildResponse(file, "Uploaded the file successfully: " + file.getOriginalFilename(), "ok");
        } catch (Exception e) {
            response.setMessages(List.of(Message.builder().filename(file.getOriginalFilename())
                    .message("Could not upload the file: " + file.getOriginalFilename() + "!")
                    .status("fail")
                    .build()));
        }
        return response;
    }

    private Response buildResponse(@RequestParam("file") MultipartFile file, String message, String status) {
        return Response.builder()
                .messages(List.of(Message.builder().filename(file.getOriginalFilename())
                        .message(message)
                        .status(status)
                        .build()))
                .build();
    }
}
