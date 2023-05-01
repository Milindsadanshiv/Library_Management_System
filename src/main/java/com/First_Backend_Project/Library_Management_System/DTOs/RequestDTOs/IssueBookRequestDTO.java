package com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookRequestDTO {
    private int card_id;
    private int book_id;
}
