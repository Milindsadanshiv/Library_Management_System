package com.First_Backend_Project.Library_Management_System.Entity;

import com.First_Backend_Project.Library_Management_System.Enums.Card_Status;
import com.First_Backend_Project.Library_Management_System.Enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//all of these four above annotation, we can write in any order
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll_No;

    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;

    private String eMail;


    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    Library_Card card;
}
