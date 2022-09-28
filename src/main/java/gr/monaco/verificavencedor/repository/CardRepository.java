package gr.monaco.verificavencedor.repository;

import gr.monaco.verificavencedor.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, String> {
    @Override
    Optional<Card> findById(String s);
}
