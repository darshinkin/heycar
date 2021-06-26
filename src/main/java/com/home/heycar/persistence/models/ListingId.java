package com.home.heycar.persistence.models;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Embeddable
@Builder
@Data
public class ListingId {
    private String dealerId;
    private String code;
}
