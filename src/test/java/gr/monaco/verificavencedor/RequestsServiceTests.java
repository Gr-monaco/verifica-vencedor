package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.Deck;
import gr.monaco.verificavencedor.services.RequestsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class RequestsServiceTests {
    @Autowired
    private RequestsService requestsService;

    @Test
    void verificaSeRequesicaoRetornaDeckStatusCode(){
        ResponseEntity<Deck> deck = requestsService.getDeck();
        Assertions.assertEquals(deck.getStatusCode(), HttpStatus.OK);
    }
}
