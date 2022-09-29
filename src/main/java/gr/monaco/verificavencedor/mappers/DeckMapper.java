package gr.monaco.verificavencedor.mappers;

import gr.monaco.verificavencedor.entities.Deck;
import gr.monaco.verificavencedor.DTOs.CardHandDTO;
import gr.monaco.verificavencedor.DTOs.DeckDTO;

public class DeckMapper {

    public static Deck fromDTO(DeckDTO deckDTO){
        return new Deck(deckDTO.getDeckId(),deckDTO.getRemaining());
    }

    public static Deck fromCardHandDTO(CardHandDTO cardHandDTO){
        return new Deck(cardHandDTO.getDeckId(), cardHandDTO.getRemaining());
    }
}
