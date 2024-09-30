package com.jwt.example.AuthMicroService.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {


    /*:
○ id: Unique identifier for each user.
○ username: Login name for the user.
○ password: Encrypted password for the user.
○ role: Role of the user, defined using an enum (Student, FacultyMember,
Administrator).
○ name: Full name of the user.
○ email: Contact email of the user.
○ phone: Contact phone number of the user.

*/
    private int id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String role;
    private String phone;


}
