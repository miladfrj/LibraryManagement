package ir.midev.librarymanagement.repositories;

import ir.midev.librarymanagement.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCardRepository extends JpaRepository<ShoppingCard, Long> {
}
