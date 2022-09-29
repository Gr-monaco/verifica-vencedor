package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.entities.CardHand;
import gr.monaco.verificavencedor.entities.Game;
import gr.monaco.verificavencedor.DTOs.*;
import gr.monaco.verificavencedor.repository.CardHandRepository;
import gr.monaco.verificavencedor.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class GameService {

    @Autowired
    RequestsService requestsService;

    @Autowired
    CardHandService cardHandService;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CardHandRepository cardHandRepository;


    public Game createGame(){
        Game game = new Game();
        ResponseEntity<DeckDTO> getDeck = requestsService.getDeck();
        DeckDTO deckDTO = getDeck.getBody();
        ResponseEntity<CardHandDTO> playerOneHand = requestsService.getHand(deckDTO.getDeckId(),5);
        ResponseEntity<CardHandDTO> playerTwoHand = requestsService.getHand(deckDTO.getDeckId(),5);
        ResponseEntity<CardHandDTO> playerThreeHand = requestsService.getHand(deckDTO.getDeckId(),5);
        ResponseEntity<CardHandDTO> playerFourHand = requestsService.getHand(deckDTO.getDeckId(),5);

        Optional<CardHand> cardHandPlayerOne = cardHandService.findHandFromDTO(Objects.requireNonNull(playerOneHand.getBody()));
        Optional<CardHand> cardHandPlayerTwo = cardHandService.findHandFromDTO(Objects.requireNonNull(playerTwoHand.getBody()));
        Optional<CardHand> cardHandPlayerThree = cardHandService.findHandFromDTO(Objects.requireNonNull(playerThreeHand.getBody()));
        Optional<CardHand> cardHandPlayerFour = cardHandService.findHandFromDTO(Objects.requireNonNull(playerFourHand.getBody()));

        game.setPlayerOneHandId(cardHandPlayerOne.get().getId());
        game.setPlayerTwoHandId(cardHandPlayerTwo.get().getId());
        game.setPlayerThreeHandId(cardHandPlayerThree.get().getId());
        game.setPlayerFourHandId(cardHandPlayerFour.get().getId());

        gameRepository.save(game);

        return game;
    }

    public int findWinner(Game game){
        CardHand handOne = cardHandRepository.findById(game.getPlayerOneHandId()).get();
        int sumPlayer1 = cardHandService.sumCardValuesFromCardHand(handOne);
        CardHand handTwo = cardHandRepository.findById(game.getPlayerTwoHandId()).get();
        int sumPlayer2 = cardHandService.sumCardValuesFromCardHand(handTwo);
        CardHand handThree = cardHandRepository.findById(game.getPlayerThreeHandId()).get();
        int sumPlayer3 = cardHandService.sumCardValuesFromCardHand(handThree);
        CardHand handFour = cardHandRepository.findById(game.getPlayerFourHandId()).get();
        int sumPlayer4 = cardHandService.sumCardValuesFromCardHand(handFour);

        log.info("handPlayer1 : {}", handOne);
        log.info("handPlayer2 : {}", handTwo);
        log.info("handPlayer3 : {}", handThree);
        log.info("handPlayer4 : {}", handFour);

        log.info("sumPlayer1 : {}", sumPlayer1);
        log.info("sumPlayer2 : {}", sumPlayer2);
        log.info("sumPlayer3 : {}", sumPlayer3);
        log.info("sumPlayer4 : {}", sumPlayer4);

        List<Integer> listInt = new ArrayList<>();
        listInt.add(sumPlayer1);
        listInt.add(sumPlayer2);
        listInt.add(sumPlayer3);
        listInt.add(sumPlayer4);

        Set<Integer> set = new HashSet<Integer>(listInt);

        if(set.size() < listInt.size()){
            return -1;
        }
        return listInt.indexOf(Collections.max(listInt));
    }

    public String endGameText(Game game){
        String jogadorVencedor = "";
        int winner = findWinner(game);
        switch (winner) {
            case -1 -> jogadorVencedor = "empate";
            case 0 -> jogadorVencedor = "Jogador 1";
            case 1 -> jogadorVencedor = "Jogador 2";
            case 2 -> jogadorVencedor = "Jogador 3";
            case 3 -> jogadorVencedor = "Jogador 4";
            default -> jogadorVencedor = "erro"; //TODO: Adicionar exception
        }

        if (jogadorVencedor.equals("empate")){
            return pegaEmpate(game);
        }
        return vencedorUnido(jogadorVencedor, winner,game);
    }

    public String vencedorUnido(String vencedorNome, int vencedorIndex, Game game){
        return String.format("Vencedor é %s com %d pontos.", vencedorNome, pegaPontoJogadorEspecifico(vencedorIndex, game));
    }

    public int pegaPontoJogadorEspecifico(int posicaoIndex, Game game){
        int pontos = 0;
        switch (posicaoIndex){
            case 0 -> pontos = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerOneHandId()).get());
            case 1 -> pontos = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerTwoHandId()).get());
            case 2 -> pontos = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerThreeHandId()).get());
            case 3 -> pontos = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerFourHandId()).get());
            default -> pontos = 0;
        }
        return pontos;
    }

    public String pegaEmpate(Game game){
        CardHand cardHandOne = cardHandRepository.findById(game.getPlayerOneHandId()).get();
        CardHand cardHandTwo = cardHandRepository.findById(game.getPlayerTwoHandId()).get();
        CardHand cardHandThree = cardHandRepository.findById(game.getPlayerThreeHandId()).get();
        CardHand cardHandFour = cardHandRepository.findById(game.getPlayerFourHandId()).get();
        String retorno = "Jogador 1 : " + cardHandOne.toString()+ "\nJogador 2 : "+cardHandTwo.toString()+"\nJogador 3 : "+ cardHandThree.toString()+ "\nJogador 4 : "+cardHandFour.toString();



        return retorno;
    }
}
