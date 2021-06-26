package com.home.heycar.persistence.dao;

import java.util.List;

import com.home.heycar.persistence.models.Listing;
import com.home.heycar.persistence.repositories.ListingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListingDao {

    private final ListingRepository listingRepository;

    public Mono<Listing> retrieveListingById(long listingId) {
        return listingRepository.findById(listingId);
    }

    public Mono<Listing> save(Listing listing) {
        return listingRepository.save(listing);
    }

    public Flux<Listing> saveAll(List<Listing> listings) {
        return listingRepository.saveAll(listings);
    }
}
