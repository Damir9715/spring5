package com.iitu.spring5.bootstrap;

import com.iitu.spring5.model.Author;
import com.iitu.spring5.model.Book;
import com.iitu.spring5.model.Publisher;
import com.iitu.spring5.repositories.AuthorRepository;
import com.iitu.spring5.repositories.BookRepository;
import com.iitu.spring5.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher oReilly = new Publisher("O'Reilly", "somewhere");
        Publisher oneS = new Publisher("1S", "farFarAway");

        publisherRepository.save(oReilly);
        publisherRepository.save(oneS);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("DDD", "123", oReilly);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rob
        Author rob = new Author("Rob", "Johnson");
        Book noEJB = new Book("HeadFirst", "456", oneS);
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(noEJB);

    }

}
