package it.ntt.myfirstcontroller.repository;

import org.springframework.data.repository.CrudRepository;

import it.ntt.myfirstcontroller.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}
