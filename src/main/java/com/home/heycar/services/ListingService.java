package com.home.heycar.services;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.home.heycar.persistence.dao.ListingDao;
import com.home.heycar.persistence.models.Listing;
import com.home.heycar.services.csv.ApacheCommonsCsvUtil;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListingService {

    private final ListingDao listingDao;

    public Mono<Listing> retrieveListingById(long listingId) {
        return listingDao.retrieveListingById(listingId);
    }

    public Mono<Listing> save(Listing listing) {
        return listingDao.save(listing);
    }

    public void store(InputStream file, String dealerId) {
        try {
            List<Listing> listings = ApacheCommonsCsvUtil.parseCsvFile(file);
            List<Listing> listingsReached = listings.stream()
                    .peek(listing -> listing.getListingId().setDealerId(dealerId))
                    .collect(Collectors.toList());
            listingDao.saveAll(listingsReached).subscribe();
        } catch(Exception e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}
