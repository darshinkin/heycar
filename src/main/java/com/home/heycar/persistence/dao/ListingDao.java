package com.home.heycar.persistence.dao;

import java.util.List;
import java.util.Optional;

import com.home.heycar.persistence.models.Listing;
import com.home.heycar.persistence.repositories.ListingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListingDao {

    private final ListingRepository listingRepository;

    public Optional<Listing> retrieveListingByCodeAndDealerId(String code, String dealerId) {
        return listingRepository.findByListingId_Code_AndListingId_DealerId(code, dealerId).stream().findFirst();
    }

    public Listing save(Listing listing) {
        return listingRepository.save(listing);
    }

    public Iterable<Listing> saveAll(List<Listing> listings) {
        return listingRepository.saveAll(listings);
    }
}
