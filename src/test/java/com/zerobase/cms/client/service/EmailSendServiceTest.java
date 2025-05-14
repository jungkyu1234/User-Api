package com.zerobase.cms.client.service;

import com.zerobase.cms.client.MailgunClient;
import com.zerobase.cms.service.test.EmailSendService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailSendServiceTest {
    @InjectMocks
    private EmailSendService emailSendService;

    @Mock
    private MailgunClient mailgunClient;

    @Test
    public void emailTest() {
        // mock 반환값 설정
        when(mailgunClient.sendEmail(any()))
                .thenReturn(ResponseEntity.ok("success"));

        // 실행
        String response = emailSendService.sendEmail();
        System.out.println("mailgun 결과값:" + response);

        // 호출 검증
        verify(mailgunClient, times(1)).sendEmail(any());
    }

        // MailgunClient를 Mockito로 mock 처리
        //MailgunClient mockMailgunClient = Mockito.mock(MailgunClient.class);

        // emailSendService의 의존성으로 mockMailgunClient 주입
       // emailSendService.setMailgunClient(mockMailgunClient);  // setMailgunClient 메서드를 추가해야 함.

        // 실행
       // emailSendService.sendEmail();

        // 메소드 호출 여부 검증
        //verify(mockMailgunClient, times(1)).sendEmail(any());

    }
//}
