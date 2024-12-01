package com.hothai.examsystem.domain.dto;

import com.hothai.examsystem.service.validator.RegisterChecked;

import jakarta.validation.constraints.Size;

@RegisterChecked
public class RegisterDTO {

    String firstName;

    String lastName;

    String email;

    @Size(min = 8, message = "Password có tối thiểu 8 ký tự")
    String password;

    String confirmPassword;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
