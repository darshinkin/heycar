package com.home.heycar.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.home.heycar.messages.Message;
import com.home.heycar.messages.Response;
import com.home.heycar.modele.ListingCreateRequest;
import com.home.heycar.persistence.models.Listing;
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
            return buildResponse(file, "No selected dealer! Please do the checking", HttpStatus.BAD_REQUEST);
        }
        if (Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            return buildResponse(file, "No selected file to upload! Please do the checking", HttpStatus.BAD_REQUEST);
        }
        if (!ApacheCommonsCsvUtil.isCSVFile(file)) {
            return buildResponse(file, "Error: this is not a CSV file!", HttpStatus.BAD_REQUEST);
        }
        try {
            listingService.store(file.getInputStream(), dealerId);
            return buildResponse(file, "Uploaded the file successfully: " + file.getOriginalFilename(), HttpStatus.OK);
        } catch (Exception e) {
            response.setMessages(List.of(Message.builder().filename(file.getOriginalFilename())
                    .message("Could not upload the file: " + file.getOriginalFilename() + "!")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build()));
        }
        return response;
    }

    private Response buildResponse(@RequestParam("file") MultipartFile file, String message, HttpStatus status) {
        return Response.builder()
                .messages(List.of(Message.builder().filename(file.getOriginalFilename())
                        .message(message)
                        .status(status)
                        .build()))
                .build();
    }

    @PostMapping(path = "${app.api.endpoint.listing.upload.json}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response uploadListingJson(@RequestBody ListingCreateRequest listingCreateRequest,
            @RequestParam("dealerId") String dealerId) {
        Listing listing = listingService.save(listingCreateRequest, dealerId);
        return Response.builder().messages(List.of(Message.builder()
                .message("File has been upload successful! " + listing)
                .status(HttpStatus.OK).build())).build();
    }

    @GetMapping(path = "${app.api.endpoint.listing.retrieve.byCodeAndDealer}")
    public Response retrieveListing(@PathVariable String code, @PathVariable String dealerId) {
        return listingService.retrieveListingByCodeAndDealerId(code, dealerId)
                .map(listing -> Response.builder().messages(List.of(Message.builder()
                        .message(String.format("Listing with code %s and dealer %s has been found. Listing: {%s}", code, dealerId, listing))
                        .status(HttpStatus.OK)
                        .build())).build())
                .orElse(Response.builder().messages(List.of(Message.builder()
                        .message(String.format("Listing with code %s and dealer %s has not been found.", code, dealerId))
                        .status(HttpStatus.NOT_FOUND)
                        .build())).build());
    }
}
