package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.CardDTO;
import gr.monaco.verificavencedor.models.CardHandDTO;
import gr.monaco.verificavencedor.models.CardMapper;
import gr.monaco.verificavencedor.repository.CardRepository;
import gr.monaco.verificavencedor.utils.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CardHandService {

    @Autowired
    CardRepository cardRepository;
    public int SumCardValues(CardHandDTO hand){
        List<CardDTO> cardDTOList = Arrays.asList(hand.getCards());
        return cardDTOList.stream().mapToInt(CardUtils::evaluate).sum();
    }

    public void saveCardHand(CardHandDTO hand){
        for (CardDTO card: hand.getCards()
             ) {
            cardRepository.save(CardMapper.fromDTO(card));
        }
    }
}
