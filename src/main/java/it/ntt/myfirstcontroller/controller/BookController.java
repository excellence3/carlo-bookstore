package it.ntt.myfirstcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ntt.myfirstcontroller.model.Author;
import it.ntt.myfirstcontroller.model.Book;
import it.ntt.myfirstcontroller.repository.AuthorRepository;
import it.ntt.myfirstcontroller.repository.BookRepository;


@Controller
public class BookController {

    BookRepository bookRepository;
    AuthorRepository authorRepository;
    
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping(value="/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }

    @GetMapping("/books/addbook")
    public String addBook (Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "bookform";
    }

    @PostMapping("/books/addbook")
    public String postBook (Book book, @RequestParam String authid){
        Author selectedAuthor = authorRepository.findById(Long.parseLong(authid)).get();
        book.setAuthor(selectedAuthor);
        
        bookRepository.save(book);

        return "redirect:/books";
    }

    
}
