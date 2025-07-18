package ir.midev.librarymanagement.service.impl;

import ir.midev.librarymanagement.dto.request.ShoppingCardRequest;
import ir.midev.librarymanagement.dto.response.ShoppingCardResponse;
import ir.midev.librarymanagement.exception.RuleException;
import ir.midev.librarymanagement.model.*;
import ir.midev.librarymanagement.repositories.BookRepository;
import ir.midev.librarymanagement.repositories.FactorRepository;
import ir.midev.librarymanagement.repositories.ShoppingCardRepository;
import ir.midev.librarymanagement.repositories.UserRepository;
import ir.midev.librarymanagement.service.ShoppingCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {

    private final ShoppingCardRepository shoppingCardRepository;
    private final FactorRepository factorRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository, FactorRepository factorRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest) {
        User user = userRepository.findById(shoppingCardRequest.getUserId())
                .orElseThrow(() -> new RuleException("user.not.exist"));
        Book book = bookRepository.findById(shoppingCardRequest.getBookId())
                .orElseThrow(() -> new RuleException("book.not.found"));
        Optional<Factor> byId = factorRepository.findByUserAndPayed(user, Payed.UNPAYED);
        Factor factor;
        factor = byId.orElseGet(() -> createFactor(user));
        factorRepository.save(factor);
        ShoppingCard shoppingCard = createShoppingCard(shoppingCardRequest, book, factor);
        return createShoppingCardResponse(shoppingCardRepository.save(shoppingCard));
    }

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard) {
        return ShoppingCardResponse.builder()
                .factorId(shoppingCard.getFactor().getId())
                .shoppingCard(shoppingCard.getId())
                .build();
    }

    private Factor createFactor(User user) {
        return Factor.builder()
                .user(user)
                .payed(Payed.UNPAYED)
                .build();
    }

    private ShoppingCard createShoppingCard(ShoppingCardRequest shoppingCardRequest, Book book, Factor factor) {
        return ShoppingCard.builder()
                .book(book)
                .factor(factor)
                .count(shoppingCardRequest.getCount())
                .build();
    }
}
