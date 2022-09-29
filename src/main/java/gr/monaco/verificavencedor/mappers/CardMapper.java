package gr.monaco.verificavencedor.mappers;

import gr.monaco.verificavencedor.entities.Card;
import gr.monaco.verificavencedor.DTOs.CardDTO;

public class CardMapper {
    public static Card fromDTO(CardDTO cardDTO){
        return new Card(cardDTO.getCode(), cardDTO.getImage());
    }
}
