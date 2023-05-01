package com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindStudentResponceDTO {
    private String name;
    private Enum department;
    private String mobNo;

}
