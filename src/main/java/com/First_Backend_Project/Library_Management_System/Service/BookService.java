package com.First_Backend_Project.Library_Management_System.Service;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import com.First_Backend_Project.Library_Management_System.Entity.Book;
import com.First_Backend_Project.Library_Management_System.Repository.AuthorRepository;
import com.First_Backend_Project.Library_Management_System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    public String addBook(Book book)throws Exception;
    public List<Book> findAllBooks();
    public List<Book> findBookOfAuthor(int id) throws Exception;
}
