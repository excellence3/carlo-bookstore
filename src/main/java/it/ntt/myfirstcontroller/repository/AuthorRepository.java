package it.ntt.myfirstcontroller.repository;

import org.springframework.data.repository.CrudRepository;

import it.ntt.myfirstcontroller.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
