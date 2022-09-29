package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.entities.Deck;
import gr.monaco.verificavencedor.DTOs.DeckDTO;
import gr.monaco.verificavencedor.mappers.DeckMapper;
import gr.monaco.verificavencedor.repository.DeckRepository;
import gr.monaco.verificavencedor.services.RequestsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;

@SpringBootTest
public class DeckDTOSavingTest {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private RequestsService requestsService;

    @Test
    void salvaDeckEBuscaDeck(){
        ResponseEntity<DeckDTO> deck = requestsService.getDeck();

        deckRepository.save(DeckMapper.fromDTO(Objects.requireNonNull(deck.getBody())));

        Optional<Deck> deck2 = deckRepository.findById(deck.getBody().getDeckId());
        Assertions.assertEquals(deck.getBody().getDeckId(), deck2.get().getDeckId());

    }
}
