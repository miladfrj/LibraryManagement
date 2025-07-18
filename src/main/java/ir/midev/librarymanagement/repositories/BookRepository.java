package ir.midev.librarymanagement.repositories;

import ir.midev.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);

    @Query("select b from Book b where b.name like :name")
    List<Book> findsByNameV2(String name);

    List<Book> findByNameContains(String name);
}
