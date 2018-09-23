package com.iitu.spring5.repositories;

import com.iitu.spring5.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
