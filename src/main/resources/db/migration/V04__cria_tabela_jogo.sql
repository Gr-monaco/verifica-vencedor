CREATE TABLE TB_GAME(
    id BIGINT AUTO_INCREMENT,
    player_one_hand_id BIGINT,
    player_two_hand_id BIGINT,
    player_three_hand_id BIGINT,
    player_four_hand_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (player_one_hand_id) REFERENCES TB_CARD_HAND(id),
    FOREIGN KEY (player_two_hand_id) REFERENCES TB_CARD_HAND(id),
    FOREIGN KEY (player_three_hand_id) REFERENCES TB_CARD_HAND(id),
    FOREIGN KEY (player_four_hand_id) REFERENCES TB_CARD_HAND(id),
)