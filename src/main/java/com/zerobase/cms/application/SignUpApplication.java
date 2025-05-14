package com.zerobase.cms.application;

import com.zerobase.cms.client.MailgunClient;
import com.zerobase.cms.client.mailgun.SendMailForm;
import com.zerobase.cms.domain.SignUpForm;
import com.zerobase.cms.domain.model.Customer;
import com.zerobase.cms.exception.CustomerException;
import com.zerobase.cms.exception.ErrorCode;
import com.zerobase.cms.service.test.SignUpCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SignUpApplication {
    private final MailgunClient mailgunClient;
    private final SignUpCustomerService signUpCustomerService;

    public void customerVerify(String email, String code) {
        signUpCustomerService.verifyEmail(email,code);
    }

    public String customerSignUp(SignUpForm form) {
       if(signUpCustomerService.isEmailExist(form.getEmail())) {
           // exception
           throw new CustomerException(ErrorCode.ALREADY_REGISTER_USER);
        }else {
           Customer c = signUpCustomerService.signUp(form);
           LocalDateTime now = LocalDateTime.now();

           String code = getRandomCode();
           SendMailForm sendMailForm = SendMailForm.builder()
                   .from("tester@dan.com")
                   .to(form.getEmail())
                   .subject("Verification Email")
                   .text(getVerificationEmailBody(c.getEmail(), c.getName(),code ))
                   .build();
           System.out.println("Send email result : " + mailgunClient.sendEmail((sendMailForm)));
            mailgunClient.sendEmail(sendMailForm);
            signUpCustomerService.ChangeCustomerValidateEmail(c.getId(),code);
            return "회원 가입에 성공하였습니다.";
       }

    }

    private String getRandomCode() {
        return RandomStringUtils.random(10,true,true);
    }

    private String getVerificationEmailBody(String email, String name, String code) {
        StringBuilder builder = new StringBuilder();
        return builder.append("Hello ").append(name).append("! Please Click Link for verification: ")
                .append("http://localhost:8081/signup/verify/customer?email=")
                .append(email)
                .append("&code=")
                .append(code).toString();
    }

    }

