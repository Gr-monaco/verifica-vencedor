package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.Card;
import gr.monaco.verificavencedor.models.CardHand;
import gr.monaco.verificavencedor.services.CardHandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CardHandServiceTests {

    @Autowired
    CardHandService cardHandService;

    @Test
    void somaDeCartas(){
        CardHand hand = new CardHand();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();
        card1.setCode("1S");
        card2.setCode("2S");
        card3.setCode("3S");
        card4.setCode("4S");
        card5.setCode("5S");
        Card[] cardArray = new Card[]{ card1, card2, card3, card4, card5 };
        hand.setCards(cardArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(15, retorno);
    }
}
