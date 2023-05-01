package com.First_Backend_Project.Library_Management_System.Controller;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import com.First_Backend_Project.Library_Management_System.Entity.Book;
import com.First_Backend_Project.Library_Management_System.Service.BookService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookService.addBook(book);
    }
    // find all the books
    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks()
    {
        return bookService.findAllBooks();
    }
    // find all the books of a particular author

    @GetMapping("/findBookOfAuthor")
    public List<Book> findBookOfAuthor(@RequestParam("id")int id) throws Exception {
     return  bookService.findBookOfAuthor(id);
    }
    //find the number of book written by the author
}
