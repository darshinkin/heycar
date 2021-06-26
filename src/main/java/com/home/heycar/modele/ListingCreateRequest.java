package com.home.heycar.modele;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListingCreateRequest {

    private String code;
    private String make;
    private String model;
    private int kW;
    private int year;
    private String color;
    private int price;
}
