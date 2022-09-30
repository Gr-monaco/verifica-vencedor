package gr.monaco.verificavencedor.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO implements Serializable {
    // Talvez fosse interessante entregar em lista para não ficar tão poluido o retorno
    private Long gameId;
    private Long playerOneHandId;
    private String playerOneHand;
    private int playerOneHandPoints;
    private Long playerTwoHandId;
    private String playerTwoHand;
    private int playerTwoHandPoints;
    private Long playerThreeHandId;
    private String playerThreeHand;
    private int playerThreeHandPoints;
    private Long playerFourHandId;
    private String playerFourHand;
    private int playerFourHandPoints;
    private String message;
    private int indexOfWinner;

}
