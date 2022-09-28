package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.*;
import gr.monaco.verificavencedor.repository.CardHandRepository;
import gr.monaco.verificavencedor.repository.CardRepository;
import gr.monaco.verificavencedor.repository.DeckRepository;
import gr.monaco.verificavencedor.services.CardHandService;
import gr.monaco.verificavencedor.services.RequestsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class CardHandServiceTests {

    @Autowired
    CardHandService cardHandService;

    @Autowired
    RequestsService requestsService;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardHandRepository cardHandRepository;

    @Autowired
    DeckRepository deckRepository;
    @Test
    void somaDeCartas1_2_3_4_5(){
        CardHandDTO hand = new CardHandDTO();
        CardDTO cardDTO1 = new CardDTO();
        CardDTO cardDTO2 = new CardDTO();
        CardDTO cardDTO3 = new CardDTO();
        CardDTO cardDTO4 = new CardDTO();
        CardDTO cardDTO5 = new CardDTO();
        cardDTO1.setCode("AS");
        cardDTO2.setCode("2S");
        cardDTO3.setCode("3S");
        cardDTO4.setCode("4S");
        cardDTO5.setCode("5S");
        CardDTO[] cardDTOArray = new CardDTO[]{cardDTO1, cardDTO2, cardDTO3, cardDTO4, cardDTO5};
        hand.setCards(cardDTOArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(15, retorno);
    }

    @Test
    void somaDeCartas6_7_8_9_10(){
        CardHandDTO hand = new CardHandDTO();
        CardDTO cardDTO1 = new CardDTO();
        CardDTO cardDTO2 = new CardDTO();
        CardDTO cardDTO3 = new CardDTO();
        CardDTO cardDTO4 = new CardDTO();
        CardDTO cardDTO5 = new CardDTO();
        cardDTO1.setCode("6S");
        cardDTO2.setCode("7S");
        cardDTO3.setCode("8S");
        cardDTO4.setCode("9S");
        cardDTO5.setCode("0S");
        CardDTO[] cardDTOArray = new CardDTO[]{cardDTO1, cardDTO2, cardDTO3, cardDTO4, cardDTO5};
        hand.setCards(cardDTOArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(40, retorno);
    }

    @Test
    void somaDeCartasA_K_Q_J_2(){
        CardHandDTO hand = new CardHandDTO();
        CardDTO cardDTO1 = new CardDTO();
        CardDTO cardDTO2 = new CardDTO();
        CardDTO cardDTO3 = new CardDTO();
        CardDTO cardDTO4 = new CardDTO();
        CardDTO cardDTO5 = new CardDTO();
        cardDTO1.setCode("AS");
        cardDTO2.setCode("KS");
        cardDTO3.setCode("QS");
        cardDTO4.setCode("JS");
        cardDTO5.setCode("2S");
        CardDTO[] cardDTOArray = new CardDTO[]{cardDTO1, cardDTO2, cardDTO3, cardDTO4, cardDTO5};
        hand.setCards(cardDTOArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(39, retorno);
    }

    @Test
    void somaDeCartasK_Q_J_10_9(){
        CardHandDTO hand = new CardHandDTO();
        CardDTO cardDTO1 = new CardDTO();
        CardDTO cardDTO2 = new CardDTO();
        CardDTO cardDTO3 = new CardDTO();
        CardDTO cardDTO4 = new CardDTO();
        CardDTO cardDTO5 = new CardDTO();
        cardDTO1.setCode("KS");
        cardDTO2.setCode("QS");
        cardDTO3.setCode("JS");
        cardDTO4.setCode("0S");
        cardDTO5.setCode("9S");
        CardDTO[] cardDTOArray = new CardDTO[]{cardDTO1, cardDTO2, cardDTO3, cardDTO4, cardDTO5};
        hand.setCards(cardDTOArray);
        int retorno = cardHandService.SumCardValues(hand);
        log.info("retorno value: {}", retorno);
        Assertions.assertEquals(55, retorno);
    }

    @Test
    void salvarCartasEDeck(){
        ResponseEntity<DeckDTO> deck = requestsService.getDeck();
        deckRepository.save(DeckMapper.fromDTO(deck.getBody()));
        ResponseEntity<CardHandDTO> response = requestsService.getHand(Objects.requireNonNull(deck.getBody()).getDeckId(), 5);
        CardHandDTO hand = response.getBody();
        System.out.println(hand.getCards().length);
        CardHand cardHandSaved = cardHandService.saveCardHand(hand);


        //Talvez fazer uma função de assertion?
        log.info("Assertion carta 1: {} : {}",hand.getCards()[0].getCode(), cardHandSaved.getCardOneId());
        Assertions.assertEquals(hand.getCards()[0].getCode(), cardHandSaved.getCardOneId());
        log.info("Assertion carta 2: {} : {}",hand.getCards()[1].getCode(), cardHandSaved.getCardTwoId());
        Assertions.assertEquals(hand.getCards()[1].getCode(), cardHandSaved.getCardTwoId());
        log.info("Assertion carta 3: {} : {}",hand.getCards()[2].getCode(), cardHandSaved.getCardThreeId());
        Assertions.assertEquals(hand.getCards()[2].getCode(), cardHandSaved.getCardThreeId());
        log.info("Assertion carta 4: {} : {}",hand.getCards()[3].getCode(), cardHandSaved.getCardFourId());
        Assertions.assertEquals(hand.getCards()[3].getCode(), cardHandSaved.getCardFourId());
        log.info("Assertion carta 5: {} : {}",hand.getCards()[4].getCode(), cardHandSaved.getCardFiveId());
        Assertions.assertEquals(hand.getCards()[4].getCode(), cardHandSaved.getCardFiveId());

        for (CardDTO card: hand.getCards()
             ) {
            Optional<Card> cardFromBase = cardRepository.findById(card.getCode());
            Assertions.assertEquals(card.getCode(),cardFromBase.get().getCode());
        }
    }
}
