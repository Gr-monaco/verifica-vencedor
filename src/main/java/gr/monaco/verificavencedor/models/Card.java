package gr.monaco.verificavencedor.models;

import lombok.Getter;

@Getter
public class Card {
    private String code;
    private String image;
    private String[] images;
    private int value;
    private String suit;
}
