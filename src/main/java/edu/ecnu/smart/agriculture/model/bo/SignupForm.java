package edu.ecnu.smart.agriculture.model.bo;

import lombok.Data;

@Data
public class SignupForm {
    private String username;
    private String pwd;
    private String email;
    private String phone;
}
