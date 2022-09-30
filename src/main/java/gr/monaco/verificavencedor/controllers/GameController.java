package gr.monaco.verificavencedor.controllers;

import gr.monaco.verificavencedor.DTOs.GameDTO;
import gr.monaco.verificavencedor.entities.Game;
import gr.monaco.verificavencedor.mappers.GameMapper;
import gr.monaco.verificavencedor.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("newGame")
    public GameDTO getGame(){
        Game game = gameService.createGame();
        GameDTO gameDTO = GameMapper.fromEntity(game);
        gameDTO = gameService.completaDTO(gameDTO);
        return gameDTO;
    }
}
