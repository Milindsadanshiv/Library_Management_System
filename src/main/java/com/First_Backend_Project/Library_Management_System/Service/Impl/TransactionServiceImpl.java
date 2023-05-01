package com.First_Backend_Project.Library_Management_System.Service.Impl;

import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.IssueBookRequestDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.IssuedBookResponseDTO;
import com.First_Backend_Project.Library_Management_System.Entity.Book;
import com.First_Backend_Project.Library_Management_System.Entity.Library_Card;
import com.First_Backend_Project.Library_Management_System.Entity.Transaction;
import com.First_Backend_Project.Library_Management_System.Enums.Card_Status;
import com.First_Backend_Project.Library_Management_System.Enums.TransactionStatus;
import com.First_Backend_Project.Library_Management_System.Repository.BookRepository;
import com.First_Backend_Project.Library_Management_System.Repository.CardRepository;
import com.First_Backend_Project.Library_Management_System.Repository.TransactionRepository;
import com.First_Backend_Project.Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;
//    @Autowired
//    private JavaMailSender emailSender;

    @Override
    public IssuedBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception {

        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssue(true);

        Library_Card card;
        try{
            card=cardRepository.findById(issueBookRequestDTO.getCard_id()).get();
        }
        catch (Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!!");
        }

        transaction.setCard(card);

        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDTO.getBook_id()).get();
        }
        catch (Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id!!!");
        }
        transaction.setBook(book);

        if (card.getStatus()!= Card_Status.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active!!!");
        }

        if (book.isIssue()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not Available!!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssue(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().add(book);
        card.getTransactionsList().add(transaction);

        cardRepository.save(card);

        //prepare response DTO

        IssuedBookResponseDTO issuedBookResponseDTO=new IssuedBookResponseDTO();
        issuedBookResponseDTO.setBookName(book.getTitle());
        issuedBookResponseDTO.setTransactionStatus(transaction.getTransactionStatus());
        issuedBookResponseDTO.setTransactionNumber(transaction.getTransactionNumber());


//
//        String text= "Congrats!! "+card.getStudent().getName()+" You have received the book "+book.getTitle();
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("");
//        message.setTo(card.getStudent().getEMail());
//        message.setSubject("Issue Book");
//        message.setText(text);
//        emailSender.send(message);

        return new IssuedBookResponseDTO();
    }
}
