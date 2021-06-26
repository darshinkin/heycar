package com.home.heycar.persistence.models;

import javax.persistence.EmbeddedId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Listing {
    @EmbeddedId
    private ListingId listingId;
    private String make;
    private String model;
    private int kW;
    private int year;
    private String color;
    private int price;
}
