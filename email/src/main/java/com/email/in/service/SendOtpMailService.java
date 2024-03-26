package com.email.in.service;

import com.email.in.dto.SendOtpMailDto;

import java.util.List;

public interface SendOtpMailService {
    List<String> sendOtp(SendOtpMailDto request);
}
