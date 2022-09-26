package gr.monaco.verificavencedor;

import gr.monaco.verificavencedor.models.Deck;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VerificavencedorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VerificavencedorApplication.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		Deck deck = restTemplate.getForObject("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", Deck.class);
		System.out.println(deck.getId());
	}
}
