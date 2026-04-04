package com.V.FBasket.VnFBasket.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class SendEmailRequestDTO {

    private String requestId;
    private String to;
    private String templateCode;
    private Map<String, Object> variables;
    private String correlationId;
}
