package com.websitesi.websitesi.Dto;

import lombok.Data;

import java.security.SecureRandom;

@Data
public class EmployeeDTO{
    private int employeeId;
    private String name;
    private String surname;
    private String department;
    private String phoneNumber;
    private String password = generateRandomPassword(8);

    private String generateRandomPassword(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return password.toString();
    }
}