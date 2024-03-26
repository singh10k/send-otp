package com.email.in.controller;

import com.email.in.dto.SendOtpMailDto;
import com.email.in.service.SendOtpMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/")
public class SendOtpMailController {
    final private SendOtpMailService sendOtpMailService;
    @PostMapping("/sendOtp")
    public ResponseEntity<List<String>> sendOtp(@RequestBody SendOtpMailDto request){
        return ResponseEntity.ok(sendOtpMailService.sendOtp(request));
    }
}
