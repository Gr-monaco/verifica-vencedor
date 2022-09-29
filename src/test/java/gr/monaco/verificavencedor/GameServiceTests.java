package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.DeckDTO;
import gr.monaco.verificavencedor.models.Game;
import gr.monaco.verificavencedor.services.RequestsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest
@Slf4j
public class GameServiceTests {
    @Autowired
    private RequestsService requestsService;

    private ResponseEntity<DeckDTO> deck;

    @BeforeAll
    void pegaDeckParaTestes(){
        deck = requestsService.getDeck();
        log.info("DECK-ID: {}", Objects.requireNonNull(deck.getBody()).getDeckId());
        Assertions.assertEquals(deck.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void GeraGame(){

    }

}
