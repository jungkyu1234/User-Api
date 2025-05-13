package com.zerobase.cms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
    private String email;
    private String name;
    private String password;
    private LocalDate birth;
    private String phone;

}
