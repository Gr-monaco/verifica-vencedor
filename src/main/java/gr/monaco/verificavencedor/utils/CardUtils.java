package gr.monaco.verificavencedor.utils;

import gr.monaco.verificavencedor.models.CardDTO;

public class CardUtils {

    public static int evaluate(CardDTO cardDTO){
        return switch (cardDTO.getCode().charAt(0)) {
            case 'A' -> 1;
            case 'K' -> 13;
            case 'Q' -> 12;
            case 'J' -> 11;
            case '0' -> 10; // Unico numero que causaria problema
            default -> Integer.parseInt(String.valueOf(cardDTO.getCode().charAt(0)));
        };
    }

    public static int evaluate(String code){
        return switch (code.charAt(0)) {
            case 'A' -> 1;
            case 'K' -> 13;
            case 'Q' -> 12;
            case 'J' -> 11;
            case '0' -> 10; // Unico numero que causaria problema
            default -> Integer.parseInt(String.valueOf(code.charAt(0)));
        };
    }
}
