package com.zerobase.cms.client;

import com.zerobase.cms.client.mailgun.SendMailForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mailgun", path = "https://api.mailgun.net/v3/")
@Qualifier("mailgun")
public interface MailgunClient {

        @PostMapping("sandbox49489100a43043ecac43ba395f15adf6.mailgun.org/messages")
        ResponseEntity<String> sendEmail(@SpringQueryMap SendMailForm form); // 적절한 응답 타입으로 수정

    }


