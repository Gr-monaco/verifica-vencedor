package gr.monaco.verificavencedor.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CardDTO implements Serializable {
    private String code;
    private String image;
    private Images images;
    private String value;
    private String suit;
}
