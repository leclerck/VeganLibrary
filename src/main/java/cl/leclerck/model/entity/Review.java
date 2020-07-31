package cl.leclerck.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter @Getter Integer id;
	@Setter @Getter String title;
	@Setter @Getter double stars;
	@Setter @Getter Date date;
	@Setter @Getter String content;
	@Setter @Getter Integer userId;
	@Setter @Getter Integer bookId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id") //Es necesario?
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "id") //Es necesario?
    private Book book;
}
