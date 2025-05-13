package com.zerobase.cms.service.test;

import com.zerobase.cms.client.MailgunClient;
import com.zerobase.cms.client.mailgun.SendMailForm;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
public class EmailSendService {
    private MailgunClient mailgunClient;


    public String sendEmail() {
        SendMailForm form = SendMailForm.builder()
                .from("jungkyu456@gmail.com")
                .to("jungkyu456@gmail.com")
                .subject("Test")
                .text("my text")
                .build();
        return mailgunClient.sendEmail(form).getBody();
    }
}
