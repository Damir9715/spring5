package com.iitu.spring5.repositories;

import com.iitu.spring5.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
