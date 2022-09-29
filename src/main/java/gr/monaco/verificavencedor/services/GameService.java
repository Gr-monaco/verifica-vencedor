package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.*;
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
        int sumPlayer1 = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerOneHandId()).get());
        int sumPlayer2 = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerTwoHandId()).get());
        int sumPlayer3 = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerThreeHandId()).get());
        int sumPlayer4 = cardHandService.sumCardValuesFromCardHand(cardHandRepository.findById(game.getPlayerFourHandId()).get());
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
}
