package com.zerobase.cms.controller;

import com.zerobase.cms.domain.SignInForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/signIn")
public class SignController {

    @PostMapping("/customer")
    public ResponseEntity<String> signCustomer(@RequestBody SignInForm form) {

        // 여기서 form으로 받은 데이터 확인 (로그용)
        System.out.println("Received SignInForm: " + form);
        // 로그인 처리 로직 (예: DB 조회, 비밀번호 확인, 토큰 발급 등)

        // 지금은 단순히 성공 응답 반환
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }


}
