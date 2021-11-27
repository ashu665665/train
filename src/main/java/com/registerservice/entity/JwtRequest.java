package com.registerservice.entity;

public class JwtRequest {

    String requestEmail;
    String requestPassword;

    public JwtRequest() {
    }

    public JwtRequest(String requestEmail, String requestPassword) {
        this.requestEmail = requestEmail;
        this.requestPassword = requestPassword;
    }

    public String getRequestEmail() {
        return requestEmail;
    }

    public void setRequestEmail(String requestEmail) {
        this.requestEmail = requestEmail;
    }

    public String getRequestPassword() {
        return requestPassword;
    }

    public void setRequestPassword(String requestPassword) {
        this.requestPassword = requestPassword;
    }
}
