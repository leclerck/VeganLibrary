package cl.leclerck.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
