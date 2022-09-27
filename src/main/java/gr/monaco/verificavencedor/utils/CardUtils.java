package gr.monaco.verificavencedor.utils;

import gr.monaco.verificavencedor.models.Card;
import gr.monaco.verificavencedor.models.CardHand;

public class CardUtils {

    public static int evaluate(Card card){
        return switch (card.getCode().charAt(0)) {
            case 'A' -> 1;
            case 'K' -> 13;
            case 'Q' -> 12;
            case 'J' -> 11;
            case '0' -> 10; // Unico numero que causaria problema
            default -> Integer.parseInt(String.valueOf(card.getCode().charAt(0)));
        };
    }
}
