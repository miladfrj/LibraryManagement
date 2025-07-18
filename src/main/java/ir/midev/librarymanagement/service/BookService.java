package ir.midev.librarymanagement.service;

import ir.midev.librarymanagement.dto.request.BookRequest;
import ir.midev.librarymanagement.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<BookResponse> findAll(Pageable pageable);

    BookResponse save(BookRequest bookRequest);

    List<BookResponse> findByName(String name);

    BookResponse findById(Long id);

    void deleted(Long id);
}
