package com.email.in.controller;

import com.email.in.dto.AuthenticationResponse;
import com.email.in.dto.RegisterRequest;
import com.email.in.service.RegistrationServic;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class ResistrationController {
private final RegistrationServic registrationServic;

@PostMapping(value="/register")
public ResponseEntity<AuthenticationResponse> registration(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(registrationServic.registration(request));
}
}
