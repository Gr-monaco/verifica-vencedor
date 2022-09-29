package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.*;
import gr.monaco.verificavencedor.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class RequestsService {

    @Value("${card.api.url}")
    private String APIURL;

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    CardHandService cardHandService;

    public ResponseEntity<DeckDTO> getDeck(){
        ResponseEntity<DeckDTO> deckResponse = new RestTemplate().getForEntity(APIURL + "new/shuffle/?deck_count=1", DeckDTO.class);
        //Refatorar para existir um DeckService
        deckRepository.save(DeckMapper.fromDTO(Objects.requireNonNull(deckResponse.getBody())));
        return deckResponse;
    }

    public ResponseEntity<CardHandDTO> getHand(String deckId, int amountOfCards){
        ResponseEntity<CardHandDTO> forEntity = new RestTemplate().getForEntity(APIURL + deckId + "/draw/?count=" + amountOfCards, CardHandDTO.class);
        CardHandDTO cardHandDTO = forEntity.getBody();
        assert cardHandDTO != null;
        cardHandService.saveCardHand(cardHandDTO);
        Deck deck = DeckMapper.fromCardHandDTO(Objects.requireNonNull(forEntity.getBody()));
        deckRepository.save(deck);
        return forEntity;
    }
}
