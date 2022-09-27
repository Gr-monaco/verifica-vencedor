package gr.monaco.verificavencedor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CardHand implements Serializable {
    private String sucess;
    @JsonProperty("deck_id")
    private String Id;
    private Card[] cards;
    private int remaining;
}
