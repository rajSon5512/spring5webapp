package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.servlet.http.PushBuilder;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author("Eric","Evan");
        Author steven=new Author("steven","hawking");
        Book ddd= new Book("Domain Driven Design ","1234");
        Book ddd_2= new Book("Brief history of time ","222");


        Publisher publisher=new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        steven.getBooks().add(ddd_2);
        ddd.getAuthors().add(eric);
        ddd_2.getAuthors().add(steven);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        authorRepository.save(steven);
        bookRepository.save(ddd_2);

        publisherRepository.save(publisher);



        System.out.println("number of books avaialble "+bookRepository.count());
        System.out.println("number of Authors avaialble "+authorRepository.count());
        System.out.println("number of publisher available "+publisherRepository.count());

    }
}
