package africa.semicolon.books.model.repositories;

import africa.semicolon.books.model.data.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    @Query(value = "select * FROM books where name LIKE %:term%", nativeQuery = true)
    List<Book> findBookByName(@Param("term") String term);
}
