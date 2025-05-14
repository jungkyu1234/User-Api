package com.zerobase.cms.service;

import com.zerobase.cms.domain.SignUpForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SignUpCustomerServiceTest {

    @Autowired
    private SignUpCustomerService service;

    @Test
    void signUp() {
        SignUpForm form = SignUpForm.builder()
                .name("name")
                .birth(LocalDate.now())
                .email("bbb@gmail.com")
                .password("01000000")
                .build();
        assertNotNull(service.signUp(form).getId());  // getId()가 null이 아니어야 함을 체크


    }
}