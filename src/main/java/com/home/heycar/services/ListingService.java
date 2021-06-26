package com.home.heycar.services;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.home.heycar.modele.ListingCreateRequest;
import com.home.heycar.persistence.dao.ListingDao;
import com.home.heycar.persistence.models.Listing;
import com.home.heycar.persistence.models.ListingId;
import com.home.heycar.services.csv.ApacheCommonsCsvUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListingService {

    private final ListingDao listingDao;

    public Optional<Listing> retrieveListingByCodeAndDealerId(String code, String dealerId) {
        return listingDao.retrieveListingByCodeAndDealerId(code, dealerId);
    }

    public Listing save(ListingCreateRequest listingCreateRequest, String dealerId) {
        Listing listing = Listing.builder()
                .listingId(ListingId.builder()
                        .dealerId(dealerId)
                        .code(listingCreateRequest.getCode()).build())
                .make(listingCreateRequest.getMake())
                .model(listingCreateRequest.getModel())
                .kW(listingCreateRequest.getKW())
                .year(listingCreateRequest.getYear())
                .color(listingCreateRequest.getColor())
                .price(listingCreateRequest.getPrice())
                .build();
        return listingDao.save(listing);
    }

    public void store(InputStream file, String dealerId) {
        try {
            List<Listing> listings = ApacheCommonsCsvUtil.parseCsvFile(file);
            List<Listing> listingsReached = listings.stream()
                    .peek(listing -> listing.getListingId().setDealerId(dealerId))
                    .collect(Collectors.toList());
            listingDao.saveAll(listingsReached);
        } catch(Exception e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}
