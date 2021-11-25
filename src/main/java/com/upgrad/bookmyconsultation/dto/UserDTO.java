package com.upgrad.bookmyconsultation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String emailId;
    private String firstName;
    private String lastName;
    private String dob;
    private String mobile;
    private String password;
    private String createdDate;
    private String salt;
}
