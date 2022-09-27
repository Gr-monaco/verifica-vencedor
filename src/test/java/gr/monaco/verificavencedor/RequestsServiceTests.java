package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.Card;
import gr.monaco.verificavencedor.models.CardHand;
import gr.monaco.verificavencedor.models.Deck;
import gr.monaco.verificavencedor.services.RequestsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RequestsServiceTests {
    @Autowired
    private RequestsService requestsService;

    private ResponseEntity<Deck> deck;

    @BeforeAll
    @Test
    void verificaSeRequesicaoRetornaDeckStatusCode(){
        deck = requestsService.getDeck();
        log.info("DECK-ID: {}", Objects.requireNonNull(deck.getBody()).getId());
        Assertions.assertEquals(deck.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void verificaSeDeckFoiEmbaralhado(){
        Assertions.assertTrue(Objects.requireNonNull(deck.getBody()).isShuffled());
    }

    @Test
    void verificaSeMaoTem5Cartas() {
        ResponseEntity<CardHand> response = requestsService.getHand(Objects.requireNonNull(deck.getBody()).getId(), 5);
        CardHand hand = response.getBody();
        assert hand != null;
        Assertions.assertEquals(hand.getCards().length, 5);
    }
}
