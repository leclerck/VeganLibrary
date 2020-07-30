package cl.leclerck.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ReviewDto extends GenericDto{
    @Setter @Getter private List<ReviewDto> reviews;
    
    public ReviewDto(String message, String code) {
        super(message, code);
    }

    public ReviewDto(List<ReviewDto> reviews, String message, String code) {
        super(message, code);
        this.reviews = reviews;
    }
}
