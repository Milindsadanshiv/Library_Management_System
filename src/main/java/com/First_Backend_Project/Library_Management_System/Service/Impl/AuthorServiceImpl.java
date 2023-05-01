package com.First_Backend_Project.Library_Management_System.Service.Impl;

import com.First_Backend_Project.Library_Management_System.Entity.Author;
import com.First_Backend_Project.Library_Management_System.Repository.AuthorRepository;
import com.First_Backend_Project.Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author Added";
    }

    @Override
    public String deleteAuthor(int id) throws Exception {
        Author author;
        try{
            author=authorRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author id is  not valid");
        }
        authorRepository.delete(author);
        return "Author deleted";
    }

    @Override
    public String updateAuthor(Author author, int id) throws Exception {
        Author author1;
        try{
            author1=authorRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author id is  not valid");
        }
        author1.setAge(author.getAge());
        author1.setName(author.getName());
        author1.setBooks(author.getBooks());
        author1.setEmail(author.getEmail());
        author1.setMobileNo(author.getMobileNo());

        authorRepository.save(author1);
        return "Author updated successfully";
    }

    @Override
    public Author findAuthor(int id) throws Exception {
        Author author;
        try{
            author=authorRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author id is not valid");
        }
        return author;
    }

    @Override
    public List<Author> findAllAuthor() {
        return authorRepository.findAll();
    }

}
