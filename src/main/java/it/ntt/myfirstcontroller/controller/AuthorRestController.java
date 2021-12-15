package it.ntt.myfirstcontroller.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.ntt.myfirstcontroller.model.Author;
import it.ntt.myfirstcontroller.repository.AuthorRepository;

@RestController
public class AuthorRestController {

    AuthorRepository authorRepository;

    public AuthorRestController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    
    @GetMapping("/api/v1/authors")
    public Iterable<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/api/v1/authors/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorRepository.findById(id).get();
    }

    @PostMapping("/api/v1/authors")
    public void postAuthor(@RequestBody Author author){
        authorRepository.save(author);
    }

    @DeleteMapping("/api/v1/authors/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
    }
}
