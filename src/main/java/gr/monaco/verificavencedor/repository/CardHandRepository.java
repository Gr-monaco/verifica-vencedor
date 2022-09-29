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

    @Query(value = "SELECT * FROM TB_CARD_HAND hand WHERE hand.deck_id = ?1 AND hand.card_one_id = ?2 AND hand.card_two_id = ?3 " +
            "AND hand.card_three_id = ?4 AND hand.card_four_id = ?5 AND hand.card_five_id = ?6", nativeQuery = true)
    CardHand findCardHand(String deckId, String cardOneId, String cardTwoId,
                          String cardThreeId, String cardFourId,
                          String cardFiveId);
}
