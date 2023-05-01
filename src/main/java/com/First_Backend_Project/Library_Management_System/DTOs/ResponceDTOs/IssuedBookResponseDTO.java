package com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs;

import com.First_Backend_Project.Library_Management_System.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssuedBookResponseDTO {

    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}
