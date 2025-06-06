package com.zerobase.cms.controller;

import com.zerobase.cms.service.test.EmailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final EmailSendService emailSendService;

    @GetMapping("/")
    public String sendEmail() {
        return emailSendService.sendEmail();
    }

}
