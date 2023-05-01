package com.First_Backend_Project.Library_Management_System.Entity;

import com.First_Backend_Project.Library_Management_System.Enums.Card_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Library_Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @CreationTimestamp
    private Date issueDate;
    @UpdateTimestamp
    private Date updatedOn;
    @Enumerated(EnumType.STRING)
    private Card_Status status;

    private String validTill;
    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued=new ArrayList<>();
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionsList=new ArrayList<>();

}
