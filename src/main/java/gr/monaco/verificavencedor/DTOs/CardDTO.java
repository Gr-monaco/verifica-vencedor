package gr.monaco.verificavencedor.DTOs;

import gr.monaco.verificavencedor.entities.Images;
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
