package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.entities.Game;
import gr.monaco.verificavencedor.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VerificavencedorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VerificavencedorApplication.class, args);
	}

	@Autowired
	GameService gameService;
	@Override
	public void run(String... args) throws Exception {
		Game game = gameService.createGame();
		String saida = gameService.endGameText(game);
		System.out.println(saida);
	}
}
