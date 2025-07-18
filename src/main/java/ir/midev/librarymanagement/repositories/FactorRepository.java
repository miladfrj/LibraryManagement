package ir.midev.librarymanagement.repositories;

import ir.midev.librarymanagement.model.Factor;
import ir.midev.librarymanagement.model.Payed;
import ir.midev.librarymanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactorRepository extends JpaRepository<Factor, Long> {

    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
