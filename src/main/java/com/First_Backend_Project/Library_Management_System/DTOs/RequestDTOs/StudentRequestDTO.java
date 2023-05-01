package com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs;

import com.First_Backend_Project.Library_Management_System.Enums.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDTO {
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;
}
