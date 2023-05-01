package com.First_Backend_Project.Library_Management_System.Controller;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import com.First_Backend_Project.Library_Management_System.Entity.Book;
import com.First_Backend_Project.Library_Management_System.Service.AuthorService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class Author_Controller {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add_Author")
    public String addBook(@RequestBody Author author)
    {
           return authorService.addAuthor(author);
    }
    //delete author by id
    @DeleteMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id")int id) throws Exception {
        return authorService.deleteAuthor(id);
    }
    //update author by id

    @PostMapping("/updateAuthor")
    public String updateAuthor(@RequestBody Author author,@RequestParam int id) throws Exception {
        return authorService.updateAuthor(author,id);
    }

    //find author by id

    @GetMapping("/findAuthor")
    public Author findAuthor(@RequestParam("id") int id) throws Exception {
        return authorService.findAuthor(id);
    }
    //find all the authors
    @GetMapping("/findAllAuthor")
    public List<Author> findAllAuthor()
    {
        return authorService.findAllAuthor();
    }
}
