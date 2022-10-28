package africa.semicolon.books.services;
import africa.semicolon.books.model.data.Book;
import africa.semicolon.books.model.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> search(String term){
        return bookRepository.findBookByName(term);
    }

    public Optional<Book> findOne(Long id){
        return bookRepository.findById(id);
    }

    public void save(Book book){
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
