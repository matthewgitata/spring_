package com.matthewgitata.demo.bootstrap;

import com.matthewgitata.demo.domain.Author;
import com.matthewgitata.demo.domain.Book;
import com.matthewgitata.demo.domain.Publisher;
import com.matthewgitata.demo.repositories.AuthorRepository;
import com.matthewgitata.demo.repositories.BookRepository;
import com.matthewgitata.demo.repositories.PublisherRepository;

/**
 * The {@code BootstrapData} class initializes some data
 * for the application to work with.
 * <p>
 * created by @matthewgitata on 16/03/2023.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
        
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(eric);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of Books: " + publisher.getBooks().size());
    }
}