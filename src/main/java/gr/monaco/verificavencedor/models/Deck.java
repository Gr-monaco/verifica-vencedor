package gr.monaco.verificavencedor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Deck implements Serializable {
    String sucess;
    @JsonProperty("deck_id")
    String Id;
    int remaining;
    boolean shuffled;
}
