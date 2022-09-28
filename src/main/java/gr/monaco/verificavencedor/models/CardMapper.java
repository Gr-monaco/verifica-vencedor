package gr.monaco.verificavencedor.models;

public class CardMapper {
    public static Card fromDTO(CardDTO cardDTO){
        return new Card(cardDTO.getCode(), cardDTO.getImage());
    }
}
