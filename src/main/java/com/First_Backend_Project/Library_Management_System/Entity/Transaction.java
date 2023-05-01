package com.First_Backend_Project.Library_Management_System.Entity;

import com.First_Backend_Project.Library_Management_System.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNumber;
    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssue;
    @Enumerated
    private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Library_Card card;

    @ManyToOne
    @JoinColumn
    Book book;


}
