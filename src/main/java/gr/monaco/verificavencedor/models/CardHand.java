package gr.monaco.verificavencedor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TB_CARD_HAND")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardHand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deckId;

    @Column(name = "cardOneId")
    private String cardOneId;

    private String cardTwoId;

    private String cardThreeId;

    private String cardFourId;

    private String cardFiveId;

    @Override
    public String toString() {
        return "[ "+cardOneId +" "+cardTwoId+" "+cardThreeId+" "+cardFourId+" "+cardFiveId+" ]";
    }
}
