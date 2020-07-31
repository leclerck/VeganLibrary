package cl.leclerck.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Setter @Getter Integer id;
	@Setter @Getter String isbn;
	@Setter @Getter String name;
	@Setter @Getter Integer year;
	@Setter @Getter String author;
	@Setter @Getter double stars;
	@Setter @Getter String description;
	@Setter @Getter String pictureUrl;
//	@Setter @Getter List<Review> reviews;  //es necesario? o buena idea?
	
	@OneToMany(cascade = CascadeType.ALL)
    private Review review;
}
