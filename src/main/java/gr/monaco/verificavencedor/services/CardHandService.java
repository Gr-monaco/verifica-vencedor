package gr.monaco.verificavencedor.services;

import gr.monaco.verificavencedor.models.*;
import gr.monaco.verificavencedor.repository.CardHandRepository;
import gr.monaco.verificavencedor.repository.CardRepository;
import gr.monaco.verificavencedor.utils.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CardHandService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardHandRepository cardHandRepository;
    public int sumCardValuesFromCardHandDTO(CardHandDTO hand){
        List<CardDTO> cardDTOList = Arrays.asList(hand.getCards());
        return cardDTOList.stream().mapToInt(CardUtils::evaluate).sum();
    }

    public CardHand saveCardHand(CardHandDTO hand){
        for (CardDTO card: hand.getCards()
             ) {
            cardRepository.save(CardMapper.fromDTO(card));
        }
        CardHand entity = CardHandMapper.fromDTO(hand);
        CardHand cardSaved = cardHandRepository.save(entity);

        return cardSaved;
    }

    public Optional<CardHand> findHandFromDTO(CardHandDTO cardHandDTO){
        return cardHandRepository.findByDeckIdAndCardOneIdAndCardTwoIdAndCardThreeIdAndCardFourIdAndCardFiveId(
                cardHandDTO.getDeckId(),
                cardHandDTO.getCards()[0].getCode(),
                cardHandDTO.getCards()[1].getCode(),
                cardHandDTO.getCards()[2].getCode(),
                cardHandDTO.getCards()[3].getCode(),
                cardHandDTO.getCards()[4].getCode()
        );
    }

    public int sumCardValuesFromCardHand(CardHand hand){
        List<String> listOfCodes = new ArrayList<>();
        listOfCodes.add(hand.getCardOneId());
        listOfCodes.add(hand.getCardTwoId());
        listOfCodes.add(hand.getCardThreeId());
        listOfCodes.add(hand.getCardFourId());
        listOfCodes.add(hand.getCardFiveId());
        return listOfCodes.stream().mapToInt(CardUtils::evaluate).sum();
    }
}
