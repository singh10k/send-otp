package com.email.in.service;

import com.email.in.dto.AuthenticationRequest;
import com.email.in.dto.AuthenticationResponse;

public interface LoginService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
