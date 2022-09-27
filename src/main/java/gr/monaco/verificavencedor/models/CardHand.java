package gr.monaco.verificavencedor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CardHand {
    private String sucess;
    @JsonProperty("deck_id")
    private String Id;
    private Card[] cards;
    private int remaining;
}
