package com.First_Backend_Project.Library_Management_System.Service;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import com.First_Backend_Project.Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {

    public String addAuthor(Author author);
    public String deleteAuthor(int id) throws Exception;

    public String updateAuthor(Author author,int id) throws Exception;

    public Author findAuthor(int id) throws Exception;
    public List<Author> findAllAuthor();

}
