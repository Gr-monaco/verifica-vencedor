package gr.monaco.verificavencedor.models;

public class DeckMapper {

    public static Deck fromDTO(DeckDTO deckDTO){
        return new Deck(deckDTO.getDeckId(),deckDTO.getRemaining());
    }

    public static Deck fromCardHandDTO(CardHandDTO cardHandDTO){
        return new Deck(cardHandDTO.getDeckId(), cardHandDTO.getRemaining());
    }
}
