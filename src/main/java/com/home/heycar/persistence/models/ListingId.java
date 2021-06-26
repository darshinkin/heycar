package com.home.heycar.persistence.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Embeddable
@Builder
@Data
public class ListingId implements Serializable {
    private String dealerId;
    private String code;
}
