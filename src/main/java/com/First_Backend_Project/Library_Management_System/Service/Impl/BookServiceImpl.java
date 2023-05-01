package com.First_Backend_Project.Library_Management_System.Service.Impl;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import com.First_Backend_Project.Library_Management_System.Entity.Book;
import com.First_Backend_Project.Library_Management_System.Repository.AuthorRepository;
import com.First_Backend_Project.Library_Management_System.Repository.BookRepository;
import com.First_Backend_Project.Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;
    BookRepository bookRepository;
    @Override
    public String addBook(Book book) throws Exception {

        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e) {
            throw new Exception("Author not present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book Added";
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookOfAuthor(int id) throws Exception {
        Author author;
        try{
            author=authorRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw new Exception("id is not valid");
        }

        return author.getBooks();
    }
}
