package com.jwt.example.AuthMicroService.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class JwtResponse {

    private  String jwtToken;
    private String userName;
}
