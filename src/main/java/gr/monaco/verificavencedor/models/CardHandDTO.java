package gr.monaco.verificavencedor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter //Foi adicionado getter para permitir a criação de testes
public class CardHandDTO implements Serializable {
    private String success;
    @JsonProperty("deck_id")
    private String deckId;
    private CardDTO[] cards;
    private int remaining;
}
