package com.First_Backend_Project.Library_Management_System.Controller;

import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.IssueBookRequestDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.IssuedBookResponseDTO;
import com.First_Backend_Project.Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/issueBook")
    public IssuedBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception {
        return transactionService.issueBook(issueBookRequestDTO);
    }
}
