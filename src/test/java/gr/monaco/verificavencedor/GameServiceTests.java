package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.entities.CardHand;
import gr.monaco.verificavencedor.entities.Game;
import gr.monaco.verificavencedor.repository.CardHandRepository;
import gr.monaco.verificavencedor.services.CardHandService;
import gr.monaco.verificavencedor.services.GameService;
import gr.monaco.verificavencedor.services.RequestsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class GameServiceTests {
    @Autowired
    private RequestsService requestsService;

    @Autowired
    GameService gameService;

    @Autowired
    CardHandService cardHandService;

    @Autowired
    CardHandRepository cardHandRepository;

    @Test
    void GeraGame(){
        Game game = gameService.createGame();
        Assertions.assertNotNull(game);
    }

    // Testando o valor do exemplo do email
    @Test
    void verificaGanhador(){
        Game game = new Game();
        CardHand cardHandPlayerOne = new CardHand();
        cardHandPlayerOne.setCardOneId("AS");
        cardHandPlayerOne.setCardTwoId("2S");
        cardHandPlayerOne.setCardThreeId("3S");
        cardHandPlayerOne.setCardFourId("4S");
        cardHandPlayerOne.setCardFiveId("5S");

        CardHand cardHandPlayerOneSaved =  cardHandRepository.save(cardHandPlayerOne);
        log.info("plauer one: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerOneSaved));

        CardHand cardHandPlayerTwo = new CardHand();
        cardHandPlayerTwo.setCardOneId("KS");
        cardHandPlayerTwo.setCardTwoId("QS");
        cardHandPlayerTwo.setCardThreeId("JS");
        cardHandPlayerTwo.setCardFourId("0S");
        cardHandPlayerTwo.setCardFiveId("9S");

        CardHand cardHandPlayerTwoSaved = cardHandRepository.save(cardHandPlayerTwo);
        log.info("plauer two: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerTwoSaved));

        CardHand cardHandPlayerThree = new CardHand();
        cardHandPlayerThree.setCardOneId("8S");
        cardHandPlayerThree.setCardTwoId("9S");
        cardHandPlayerThree.setCardThreeId("2S");
        cardHandPlayerThree.setCardFourId("AS");
        cardHandPlayerThree.setCardFiveId("JS");

        CardHand cardHandPlayerThreeSaved = cardHandRepository.save(cardHandPlayerThree);
        log.info("plauer three: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerThreeSaved));

        CardHand cardHandPlayerFour = new CardHand();
        cardHandPlayerFour.setCardOneId("2S");
        cardHandPlayerFour.setCardTwoId("2S");
        cardHandPlayerFour.setCardThreeId("5S");
        cardHandPlayerFour.setCardFourId("7S");
        cardHandPlayerFour.setCardFiveId("2S");

        CardHand cardHandPlayerFourSaved = cardHandRepository.save(cardHandPlayerFour);
        log.info("plauer four: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerFourSaved));

        game.setPlayerOneHandId(cardHandPlayerOneSaved.getId());
        game.setPlayerTwoHandId(cardHandPlayerTwoSaved.getId());
        game.setPlayerThreeHandId(cardHandPlayerThreeSaved.getId());
        game.setPlayerFourHandId(cardHandPlayerFourSaved.getId());

        int winner = gameService.findWinner(game);

        log.info("{}", winner);

        //Será 1 pq o 1 é a segunda posição da lista
        Assertions.assertEquals(1,winner);

    }

    @Test
    void verificaGanhadorEmpate(){
        Game game = new Game();
        CardHand cardHandPlayerOne = new CardHand();
        cardHandPlayerOne.setCardOneId("AS");
        cardHandPlayerOne.setCardTwoId("2S");
        cardHandPlayerOne.setCardThreeId("3S");
        cardHandPlayerOne.setCardFourId("4S");
        cardHandPlayerOne.setCardFiveId("5S");

        CardHand cardHandPlayerOneSaved =  cardHandRepository.save(cardHandPlayerOne);
        log.info("plauer one: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerOneSaved));

        CardHand cardHandPlayerTwo = new CardHand();
        cardHandPlayerTwo.setCardOneId("AS");
        cardHandPlayerTwo.setCardTwoId("2S");
        cardHandPlayerTwo.setCardThreeId("3S");
        cardHandPlayerTwo.setCardFourId("4S");
        cardHandPlayerTwo.setCardFiveId("5S");

        CardHand cardHandPlayerTwoSaved = cardHandRepository.save(cardHandPlayerTwo);
        log.info("plauer two: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerTwoSaved));

        CardHand cardHandPlayerThree = new CardHand();
        cardHandPlayerThree.setCardOneId("8S");
        cardHandPlayerThree.setCardTwoId("9S");
        cardHandPlayerThree.setCardThreeId("2S");
        cardHandPlayerThree.setCardFourId("AS");
        cardHandPlayerThree.setCardFiveId("JS");

        CardHand cardHandPlayerThreeSaved = cardHandRepository.save(cardHandPlayerThree);
        log.info("plauer three: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerThreeSaved));

        CardHand cardHandPlayerFour = new CardHand();
        cardHandPlayerFour.setCardOneId("2S");
        cardHandPlayerFour.setCardTwoId("2S");
        cardHandPlayerFour.setCardThreeId("5S");
        cardHandPlayerFour.setCardFourId("7S");
        cardHandPlayerFour.setCardFiveId("2S");

        CardHand cardHandPlayerFourSaved = cardHandRepository.save(cardHandPlayerFour);
        log.info("plauer four: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerFourSaved));

        game.setPlayerOneHandId(cardHandPlayerOneSaved.getId());
        game.setPlayerTwoHandId(cardHandPlayerTwoSaved.getId());
        game.setPlayerThreeHandId(cardHandPlayerThreeSaved.getId());
        game.setPlayerFourHandId(cardHandPlayerFourSaved.getId());

        int winner = gameService.findWinner(game);

        log.info("{}", winner);

        Assertions.assertEquals(-1,winner);

    }

    @Test
    void verificaTextoDeVencedor(){
        Game game = new Game();
        CardHand cardHandPlayerOne = new CardHand();
        cardHandPlayerOne.setCardOneId("AS");
        cardHandPlayerOne.setCardTwoId("2S");
        cardHandPlayerOne.setCardThreeId("3S");
        cardHandPlayerOne.setCardFourId("4S");
        cardHandPlayerOne.setCardFiveId("5S");

        CardHand cardHandPlayerOneSaved =  cardHandRepository.save(cardHandPlayerOne);
        log.info("plauer one: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerOneSaved));

        CardHand cardHandPlayerTwo = new CardHand();
        cardHandPlayerTwo.setCardOneId("KS");
        cardHandPlayerTwo.setCardTwoId("QS");
        cardHandPlayerTwo.setCardThreeId("JS");
        cardHandPlayerTwo.setCardFourId("0S");
        cardHandPlayerTwo.setCardFiveId("9S");

        CardHand cardHandPlayerTwoSaved = cardHandRepository.save(cardHandPlayerTwo);
        log.info("plauer two: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerTwoSaved));

        CardHand cardHandPlayerThree = new CardHand();
        cardHandPlayerThree.setCardOneId("8S");
        cardHandPlayerThree.setCardTwoId("9S");
        cardHandPlayerThree.setCardThreeId("2S");
        cardHandPlayerThree.setCardFourId("AS");
        cardHandPlayerThree.setCardFiveId("JS");

        CardHand cardHandPlayerThreeSaved = cardHandRepository.save(cardHandPlayerThree);
        log.info("plauer three: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerThreeSaved));

        CardHand cardHandPlayerFour = new CardHand();
        cardHandPlayerFour.setCardOneId("2S");
        cardHandPlayerFour.setCardTwoId("2S");
        cardHandPlayerFour.setCardThreeId("5S");
        cardHandPlayerFour.setCardFourId("7S");
        cardHandPlayerFour.setCardFiveId("2S");

        CardHand cardHandPlayerFourSaved = cardHandRepository.save(cardHandPlayerFour);
        log.info("plauer four: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerFourSaved));

        game.setPlayerOneHandId(cardHandPlayerOneSaved.getId());
        game.setPlayerTwoHandId(cardHandPlayerTwoSaved.getId());
        game.setPlayerThreeHandId(cardHandPlayerThreeSaved.getId());
        game.setPlayerFourHandId(cardHandPlayerFourSaved.getId());

        int winner = gameService.findWinner(game);

        log.info("{}", winner);

        //Será 1 pq o 1 é a segunda posição da lista
        Assertions.assertEquals(1,winner);

        String saidaDeTexto = gameService.endGameText(game);
    }

    @Test
    void  gameWinnerTeste(){
        Game game = new Game();
        CardHand cardHandPlayerOne = new CardHand();
        cardHandPlayerOne.setCardOneId("AS");
        cardHandPlayerOne.setCardTwoId("2S");
        cardHandPlayerOne.setCardThreeId("3S");
        cardHandPlayerOne.setCardFourId("4S");
        cardHandPlayerOne.setCardFiveId("5S");

        CardHand cardHandPlayerOneSaved =  cardHandRepository.save(cardHandPlayerOne);
        log.info("plauer one: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerOneSaved));

        CardHand cardHandPlayerTwo = new CardHand();
        cardHandPlayerTwo.setCardOneId("KS");
        cardHandPlayerTwo.setCardTwoId("QS");
        cardHandPlayerTwo.setCardThreeId("JS");
        cardHandPlayerTwo.setCardFourId("0S");
        cardHandPlayerTwo.setCardFiveId("9S");

        CardHand cardHandPlayerTwoSaved = cardHandRepository.save(cardHandPlayerTwo);
        log.info("plauer two: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerTwoSaved));

        CardHand cardHandPlayerThree = new CardHand();
        cardHandPlayerThree.setCardOneId("8S");
        cardHandPlayerThree.setCardTwoId("9S");
        cardHandPlayerThree.setCardThreeId("2S");
        cardHandPlayerThree.setCardFourId("AS");
        cardHandPlayerThree.setCardFiveId("JS");

        CardHand cardHandPlayerThreeSaved = cardHandRepository.save(cardHandPlayerThree);
        log.info("plauer three: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerThreeSaved));

        CardHand cardHandPlayerFour = new CardHand();
        cardHandPlayerFour.setCardOneId("2S");
        cardHandPlayerFour.setCardTwoId("2S");
        cardHandPlayerFour.setCardThreeId("5S");
        cardHandPlayerFour.setCardFourId("7S");
        cardHandPlayerFour.setCardFiveId("2S");

        CardHand cardHandPlayerFourSaved = cardHandRepository.save(cardHandPlayerFour);
        log.info("plauer four: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerFourSaved));

        game.setPlayerOneHandId(cardHandPlayerOneSaved.getId());
        game.setPlayerTwoHandId(cardHandPlayerTwoSaved.getId());
        game.setPlayerThreeHandId(cardHandPlayerThreeSaved.getId());
        game.setPlayerFourHandId(cardHandPlayerFourSaved.getId());

        String saida = gameService.endGameText(game);

        log.info("{}", saida);

        Assertions.assertEquals("Vencedor é Jogador 2 com 55 pontos.",saida);


    }

    @Test
    void testaEmpate2(){
        Game game = new Game();
        CardHand cardHandPlayerOne = new CardHand();
        cardHandPlayerOne.setCardOneId("AS");
        cardHandPlayerOne.setCardTwoId("2S");
        cardHandPlayerOne.setCardThreeId("3S");
        cardHandPlayerOne.setCardFourId("4S");
        cardHandPlayerOne.setCardFiveId("5S");

        CardHand cardHandPlayerOneSaved =  cardHandRepository.save(cardHandPlayerOne);
        log.info("plauer one: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerOneSaved));

        CardHand cardHandPlayerTwo = new CardHand();
        cardHandPlayerTwo.setCardOneId("8S");
        cardHandPlayerTwo.setCardTwoId("9S");
        cardHandPlayerTwo.setCardThreeId("2S");
        cardHandPlayerTwo.setCardFourId("AS");
        cardHandPlayerTwo.setCardFiveId("JS");

        CardHand cardHandPlayerTwoSaved = cardHandRepository.save(cardHandPlayerTwo);
        log.info("plauer two: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerTwoSaved));

        CardHand cardHandPlayerThree = new CardHand();
        cardHandPlayerThree.setCardOneId("8S");
        cardHandPlayerThree.setCardTwoId("9S");
        cardHandPlayerThree.setCardThreeId("2S");
        cardHandPlayerThree.setCardFourId("AS");
        cardHandPlayerThree.setCardFiveId("JS");

        CardHand cardHandPlayerThreeSaved = cardHandRepository.save(cardHandPlayerThree);
        log.info("plauer three: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerThreeSaved));

        CardHand cardHandPlayerFour = new CardHand();
        cardHandPlayerFour.setCardOneId("2S");
        cardHandPlayerFour.setCardTwoId("2S");
        cardHandPlayerFour.setCardThreeId("5S");
        cardHandPlayerFour.setCardFourId("7S");
        cardHandPlayerFour.setCardFiveId("2S");

        CardHand cardHandPlayerFourSaved = cardHandRepository.save(cardHandPlayerFour);
        log.info("plauer four: {}", cardHandService.sumCardValuesFromCardHand(cardHandPlayerFourSaved));

        game.setPlayerOneHandId(cardHandPlayerOneSaved.getId());
        game.setPlayerTwoHandId(cardHandPlayerTwoSaved.getId());
        game.setPlayerThreeHandId(cardHandPlayerThreeSaved.getId());
        game.setPlayerFourHandId(cardHandPlayerFourSaved.getId());

        String saida = gameService.endGameText(game);

        Assertions.assertEquals("Jogador 1 : [ AS 2S 3S 4S 5S ]\n" +
                "Jogador 2 : [ 8S 9S 2S AS JS ]\n" +
                "Jogador 3 : [ 8S 9S 2S AS JS ]\n" +
                "Jogador 4 : [ 2S 2S 5S 7S 2S ]", saida);
    }
}
