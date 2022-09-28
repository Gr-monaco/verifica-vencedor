package gr.monaco.verificavencedor.models;


import gr.monaco.verificavencedor.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CardHandMapper {

    public static CardHand fromDTO(CardHandDTO cardHandDTO){
        CardHand cardHand = new CardHand();
        cardHand.setDeckId(cardHandDTO.getId());
        cardHand.setCardOneId(cardHandDTO.getCards()[0].getCode());
        cardHand.setCardTwoId(cardHandDTO.getCards()[1].getCode());
        cardHand.setCardThreeId(cardHandDTO.getCards()[2].getCode());
        cardHand.setCardFourId(cardHandDTO.getCards()[3].getCode());
        cardHand.setCardFiveId(cardHandDTO.getCards()[4].getCode());
        return cardHand;
    }
}
