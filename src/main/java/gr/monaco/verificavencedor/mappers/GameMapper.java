package gr.monaco.verificavencedor.mappers;

import gr.monaco.verificavencedor.DTOs.GameDTO;
import gr.monaco.verificavencedor.entities.Game;

public class GameMapper {

    public static GameDTO fromEntity(Game game){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGameId(game.getId());
        gameDTO.setPlayerOneHandId(game.getPlayerOneHandId());
        gameDTO.setPlayerTwoHandId(game.getPlayerTwoHandId());
        gameDTO.setPlayerThreeHandId(game.getPlayerThreeHandId());
        gameDTO.setPlayerFourHandId(game.getPlayerFourHandId());
        return gameDTO;
    }
}
