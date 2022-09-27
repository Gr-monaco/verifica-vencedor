package gr.monaco.verificavencedor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerServiceTest {

    @Test
    void verificaVencedor(){
        String jogadorVencedor = "";
        Assertions.assertEquals("Jogador 2",jogadorVencedor);
    }
}
