package gr.monaco.verificavencedor.models;

public class DeckMapper {

    public static Deck fromDTO(DeckDTO deckDTO){
        return new Deck(deckDTO.getDeckId(),deckDTO.getRemaining());
    }
}
