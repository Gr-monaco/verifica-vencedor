package gr.monaco.verificavencedor.repository;

import gr.monaco.verificavencedor.models.CardHand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CardHandRepository extends JpaRepository<CardHand, Long> {
    @Override
    Optional<CardHand> findById(Long aLong);

    @Override
    <S extends CardHand> S save(S entity);

    //TODO: Colocar em Query
    Optional<CardHand> findByDeckIdAndCardOneIdAndCardTwoIdAndCardThreeIdAndCardFourIdAndCardFiveId(String deckId, String cardOneId, String cardTwoId,
                                                                                     String cardThreeId, String cardFourId,
                                                                                     String cardFiveId);
}
