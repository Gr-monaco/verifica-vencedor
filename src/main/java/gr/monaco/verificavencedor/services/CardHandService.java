package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.Card;
import gr.monaco.verificavencedor.models.CardHand;
import gr.monaco.verificavencedor.utils.CardUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class CardHandService {

    public int SumCardValues(CardHand hand){
        List<Card> cardList = Arrays.asList(hand.getCards());
        return cardList.stream().mapToInt(CardUtils::evaluate).sum();
    }
}
