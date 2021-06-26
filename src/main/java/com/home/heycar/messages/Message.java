package com.home.heycar.messages;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String filename;
    private String message;
    private HttpStatus status;
}
