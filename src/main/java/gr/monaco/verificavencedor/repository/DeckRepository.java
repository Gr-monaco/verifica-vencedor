package gr.monaco.verificavencedor.repository;

import gr.monaco.verificavencedor.models.Deck;
import gr.monaco.verificavencedor.models.DeckDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeckRepository extends JpaRepository<Deck, String> {
    @Override
    Optional<Deck> findById(String s);
}
