package cl.leclerck.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Book {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	Integer id; 

	String isbn;
	String name;
	Integer year;
	String author;
	double stars;
	String description;
	String pictureUrl;

	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<Review> reviews;
	
	public String toJson() {
        Book aux = new Book(id, isbn, name, year, author, stars, description, pictureUrl, reviews);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(aux);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
    }
}
