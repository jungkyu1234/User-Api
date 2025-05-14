package com.zerobase.cms.controller;

import com.zerobase.cms.application.SignUpApplication;
import com.zerobase.cms.domain.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpApplication signUpApplication;

    @PostMapping()
    public ResponseEntity<String> customerSignUp(@RequestBody SignUpForm form) {
        return ResponseEntity.ok(signUpApplication.customerSignUp(form));
    }

    @PutMapping("/verify/customer")
    public ResponseEntity<String> verifyCustomer(String email, String code) {
        signUpApplication.customerVerify(email,code);
        return ResponseEntity.ok("인증이 완료되었습니다.");
    }

}
