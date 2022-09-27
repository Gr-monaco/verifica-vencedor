package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.CardHand;
import gr.monaco.verificavencedor.models.Deck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestsService {

    @Value("${card.api.url}")
    private String APIURL;

    public ResponseEntity<Deck> getDeck(){
        return new RestTemplate().getForEntity(APIURL+"new/shuffle/?deck_count=1", Deck.class);
    }

    public ResponseEntity<CardHand> getHand(String deckId, int amountOfCards){
        return  new RestTemplate().getForEntity(APIURL+deckId+"/draw/?count="+ amountOfCards, CardHand.class);
    }
}
