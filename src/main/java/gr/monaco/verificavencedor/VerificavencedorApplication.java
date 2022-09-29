package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.DeckDTO;
import gr.monaco.verificavencedor.models.Game;
import gr.monaco.verificavencedor.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VerificavencedorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VerificavencedorApplication.class, args).close();
	}

	@Autowired
	GameService gameService;
	@Override
	public void run(String... args) throws Exception {
		Game game = gameService.createGame();
		int vencedor = gameService.findWinner(game);
		String saida = gameService.endGameText(game);
		System.out.println(saida);
	}
}
