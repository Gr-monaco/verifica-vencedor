package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.*;
import gr.monaco.verificavencedor.repository.CardHandRepository;
import gr.monaco.verificavencedor.repository.DeckRepository;
import gr.monaco.verificavencedor.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    RequestsService requestsService;

    @Autowired
    CardHandService cardHandService;

    @Autowired
    GameRepository gameRepository;

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
}
