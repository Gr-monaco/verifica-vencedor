package gr.monaco.verificavencedor.models;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Card implements Serializable {
    private String code;
    private String image;
    private Images images;
    private String value;
    private String suit;
}
