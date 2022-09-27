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
    void somaDeCartas1_2_3_4_5(){
        CardHand hand = new CardHand();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();
        card1.setCode("AS");
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

    @Test
    void somaDeCartas6_7_8_9_10(){
        CardHand hand = new CardHand();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();
        card1.setCode("6S");
        card2.setCode("7S");
        card3.setCode("8S");
        card4.setCode("9S");
        card5.setCode("0S");
        Card[] cardArray = new Card[]{ card1, card2, card3, card4, card5 };
        hand.setCards(cardArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(40, retorno);
    }

    @Test
    void somaDeCartasA_K_Q_J_2(){
        CardHand hand = new CardHand();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();
        card1.setCode("AS");
        card2.setCode("KS");
        card3.setCode("QS");
        card4.setCode("JS");
        card5.setCode("2S");
        Card[] cardArray = new Card[]{ card1, card2, card3, card4, card5 };
        hand.setCards(cardArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(39, retorno);
    }

    @Test
    void somaDeCartasK_Q_J_10_9(){
        CardHand hand = new CardHand();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();
        card1.setCode("KS");
        card2.setCode("QS");
        card3.setCode("JS");
        card4.setCode("0S");
        card5.setCode("9S");
        Card[] cardArray = new Card[]{ card1, card2, card3, card4, card5 };
        hand.setCards(cardArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(55, retorno);
    }
}
