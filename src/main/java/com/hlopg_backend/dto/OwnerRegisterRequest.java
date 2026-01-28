package com.hlopg_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRegisterRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
}