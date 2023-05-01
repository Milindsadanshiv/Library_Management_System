package com.First_Backend_Project.Library_Management_System.Service;

import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.IssueBookRequestDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.IssuedBookResponseDTO;
import org.springframework.stereotype.Service;


public interface TransactionService {
    public IssuedBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception;
}
