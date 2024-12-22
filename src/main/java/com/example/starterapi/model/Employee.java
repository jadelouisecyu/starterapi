package com.example.starterapi.model;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeNo;
    private String title;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String gender;
    private String emailAddress;

    public void setEmployeeNo(UUID employeeNo)
    {
        this.employeeNo = employeeNo;
    }

    public UUID getEmployeeNo()
    {
        return employeeNo;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setFirstName(String fName)
    {
        this.firstName = fName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lName)
    {
        this.lastName = lName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setDateOfBirth(LocalDate dob)
    {
        this.dateOfBirth = dob;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }

    public void setEmail(String email)
    {
        this.emailAddress = email;
    }

    public String getEmail()
    {
        return emailAddress;
    }
}
