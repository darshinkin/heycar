package com.home.heycar.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.heycar.persistence.models.Listing;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {

    List<Listing> findByListingId_Code_AndListingId_DealerId(String code, String dealerId);
}
