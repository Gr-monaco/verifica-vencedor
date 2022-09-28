package gr.monaco.verificavencedor.models;


public class CardHandMapper {

    public static CardHand fromDTO(CardHandDTO cardHandDTO){
        CardHand cardHand = new CardHand();
        cardHand.setDeckId(cardHandDTO.getDeckId());
        cardHand.setCardOneId(cardHandDTO.getCards()[0].getCode());
        cardHand.setCardTwoId(cardHandDTO.getCards()[1].getCode());
        cardHand.setCardThreeId(cardHandDTO.getCards()[2].getCode());
        cardHand.setCardFourId(cardHandDTO.getCards()[3].getCode());
        cardHand.setCardFiveId(cardHandDTO.getCards()[4].getCode());
        return cardHand;
    }
}
