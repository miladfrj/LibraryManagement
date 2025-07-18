package ir.midev.librarymanagement.service.impl;

import ir.midev.librarymanagement.dto.request.BookRequest;
import ir.midev.librarymanagement.dto.response.BookResponse;
import ir.midev.librarymanagement.exception.RuleException;
import ir.midev.librarymanagement.model.Book;
import ir.midev.librarymanagement.repositories.BookRepository;
import ir.midev.librarymanagement.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map((book -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build()));
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName = bookRepository.findByName(bookRequest.getName());

        if (byName.isPresent())
            throw new RuleException("bok.is.exist");
        Book save = bookRepository.save(createBook(bookRequest));
        return createBookResponse(save);
    }

    @Override
    public List<BookResponse> findByName(String name) {
        return bookRepository.findByNameContains(name)
                .stream().map((book) -> BookResponse.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .price(book.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
        return createBookResponse(findByIdReturnBook(id));
    }


    @Override
    public void deleted(Long id) {
        Book byId = findByIdReturnBook(id);
        bookRepository.delete(byId);
    }

    private BookResponse createBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();

    }

    private Book createBook(BookRequest bookRequest) {
        return Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }

    private Book findByIdReturnBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuleException("book.not.found"));
    }
}
