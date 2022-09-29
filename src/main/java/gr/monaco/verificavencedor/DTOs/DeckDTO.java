package gr.monaco.verificavencedor.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Table(name="TB_DECk")
public class DeckDTO implements Serializable {
    private String sucess;
    @Id
    @JsonProperty("deck_id")
    private String deckId;
    private int remaining;
    private boolean shuffled;
}
