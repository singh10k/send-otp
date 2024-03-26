package com.email.in.service;

import com.email.in.dto.AuthenticationResponse;
import com.email.in.dto.RegisterRequest;

public interface RegistrationServic {
    AuthenticationResponse registration(RegisterRequest request);
}
