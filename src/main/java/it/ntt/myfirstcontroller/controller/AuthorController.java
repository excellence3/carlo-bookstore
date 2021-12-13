package it.ntt.myfirstcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.ntt.myfirstcontroller.model.Author;
import it.ntt.myfirstcontroller.repository.AuthorRepository;

@Controller
public class AuthorController {
    
    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

    @GetMapping("/authors/{id}")
    public String getAuthor(Model model, @PathVariable Long id){
        model.addAttribute("author", authorRepository.findById(id).get());
        return "author";
    }

    @GetMapping("/authors/newauthor")
    public String getAuthorForm(){

        return "authorform";
    }

    @PostMapping("/authors/newauthor")
    public String postNewAuthor(Author author){
        authorRepository.save(author);

        return "redirect:/authors";
    }


}
