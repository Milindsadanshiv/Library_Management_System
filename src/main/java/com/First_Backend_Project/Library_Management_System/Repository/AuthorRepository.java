package com.First_Backend_Project.Library_Management_System.Repository;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
