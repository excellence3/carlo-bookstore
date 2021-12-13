package it.ntt.myfirstcontroller.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.ntt.myfirstcontroller.model.Author;
import it.ntt.myfirstcontroller.model.Book;
import it.ntt.myfirstcontroller.repository.AuthorRepository;
import it.ntt.myfirstcontroller.repository.BookRepository;

@Component
public class DataBootstrap implements CommandLineRunner{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DataBootstrap(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author carlo = new Author();
        carlo.setName("Carlo");
        carlo.setSurname("Centofanti");
        
        Book book1 = new Book();
        book1.setTitle("Il mio primo libro");
        book1.setIsbn("abc123");

        book1.setAuthor(carlo);

        authorRepository.save(carlo);
        bookRepository.save(book1);
    }
    
}
