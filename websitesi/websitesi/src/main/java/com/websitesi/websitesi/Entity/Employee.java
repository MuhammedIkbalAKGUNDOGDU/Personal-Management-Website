package com.websitesi.websitesi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_table")
public class Employee{

    @Id
    @Column(name = "employee_id", length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name", length = 255)
    private String name;

    @Column(name = "employee_lastname", length = 255)
    private String surname;
    @Column(name = "employee_department", length = 255)
    private String department;
    @Column(name = "employee_phone_number", length = 255)
    private String phoneNumber;
    @Column(name = "employee_password", length = 255)
    private String password;

    public Employee(int employeeId, String name, String surname, String department, String phoneNumber, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Employee() {
    }
}
