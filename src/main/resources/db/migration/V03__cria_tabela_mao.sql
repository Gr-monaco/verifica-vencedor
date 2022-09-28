CREATE TABLE TB_CARD_HAND(
    id BIGINT AUTO_INCREMENT,
    deck_id VARCHAR(255),
    card_one_id VARCHAR(2),
    card_two_id VARCHAR(2),
    card_three_id VARCHAR(2),
    card_four_id VARCHAR(2),
    card_five_id VARCHAR(2),
    PRIMARY KEY (id),
    FOREIGN KEY (deck_id) REFERENCES TB_DECK(deck_id),
    FOREIGN KEY(card_one_id) REFERENCES TB_CARD(code),
    FOREIGN KEY(card_two_id) REFERENCES TB_CARD(code),
    FOREIGN KEY(card_three_id) REFERENCES TB_CARD(code),
    FOREIGN KEY(card_four_id) REFERENCES TB_CARD(code),
    FOREIGN KEY(card_five_id) REFERENCES TB_CARD(code)
);