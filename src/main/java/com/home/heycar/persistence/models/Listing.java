package com.home.heycar.persistence.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PHONE")
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
