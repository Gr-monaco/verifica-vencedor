package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.DTOs.CardHandDTO;
import gr.monaco.verificavencedor.DTOs.DeckDTO;
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

    private ResponseEntity<DeckDTO> deck;

    @BeforeAll
    @Test
    void verificaSeRequesicaoRetornaDeckStatusCode(){
        deck = requestsService.getDeck();
        log.info("DECK-ID: {}", Objects.requireNonNull(deck.getBody()).getDeckId());
        Assertions.assertEquals(deck.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void verificaSeDeckFoiEmbaralhado(){
        Assertions.assertTrue(Objects.requireNonNull(deck.getBody()).isShuffled());
    }

    @Test
    void verificaSeMaoTem5Cartas() {
        ResponseEntity<CardHandDTO> response = requestsService.getHand(Objects.requireNonNull(deck.getBody()).getDeckId(), 5);
        CardHandDTO hand = response.getBody();
        assert hand != null;
        Assertions.assertEquals(hand.getCards().length, 5);
    }

}
