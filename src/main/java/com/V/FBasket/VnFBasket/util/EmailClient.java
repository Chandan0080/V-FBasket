package com.V.FBasket.VnFBasket.util;

import com.V.FBasket.VnFBasket.dto.SendEmailRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service", url = "${email.service.url}")
public interface EmailClient {

    @PostMapping("/send-email")
    void sendEmail(@RequestBody SendEmailRequestDTO emailRequest);
}
