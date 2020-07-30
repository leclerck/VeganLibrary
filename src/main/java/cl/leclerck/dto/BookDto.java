package cl.leclerck.dto;

import java.util.List;

import cl.leclerck.model.entity.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class BookDto extends GenericDto{
    @Setter @Getter List<Book> books;
    
    public BookDto(String message, String code) {
        super(message, code);
    }
    
    public BookDto(List<Book> books, String message, String code) {
        super(message, code);
        this.books = books;
    }
}
