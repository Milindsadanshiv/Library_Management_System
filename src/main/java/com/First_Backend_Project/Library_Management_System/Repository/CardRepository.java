package com.First_Backend_Project.Library_Management_System.Repository;

import com.First_Backend_Project.Library_Management_System.Entity.Library_Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Library_Card,Integer> {
}
