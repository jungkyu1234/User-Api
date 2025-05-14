package com.zerobase.cms.application;

import com.zerobase.cms.domain.SignInForm;
import com.zerobase.cms.domain.model.Customer;
import com.zerobase.cms.exception.CustomerException;
import com.zerobase.cms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.zerobase.cms.exception.ErrorCode.LOGIN_CHECK_FAIL;

@Service
@RequiredArgsConstructor
public class SignApplication {

    private final CustomerService customerService;


    public String customerLoginToken(SignInForm form) {
        // 1. 로그인 가능 여부
        Customer c = customerService.findValidCustomer(form.getEmail(),form.getPassword())
                .orElseThrow(()->new CustomerException(LOGIN_CHECK_FAIL));
        // 2. 토큰을 발행하고
        // 3. 토큰을 response한다.
        return "";
    }

}
