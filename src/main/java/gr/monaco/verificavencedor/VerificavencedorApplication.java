package gr.monaco.verificavencedor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VerificavencedorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VerificavencedorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String stringRetorno = restTemplate.getForObject("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", String.class);
		System.out.println(stringRetorno);
	}
}
