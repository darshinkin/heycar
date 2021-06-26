package com.home.heycar.persistence.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.home.heycar.persistence.models.Listing;

@Repository
public interface ListingRepository extends R2dbcRepository<Listing, Long> {
}
