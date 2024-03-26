package com.email.in.dto;

import lombok.Data;

@Data
public class SendOtpMailDto {
    private String toMail;
    private String mailId;
}
