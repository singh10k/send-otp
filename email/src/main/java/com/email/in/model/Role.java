package com.email.in.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

public enum Role {
    USER,
    ADMIN,
    MANAGER;
    public List<SimpleGrantedAuthority> getAuthorities(){
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}
