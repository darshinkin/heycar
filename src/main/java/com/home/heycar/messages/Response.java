package com.home.heycar.messages;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private List<Message> messages;
    private Error error;
    private String errStatus;
}
