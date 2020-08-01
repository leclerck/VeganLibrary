package cl.leclerck.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class BookUser implements Serializable {

    private static final long serialVersionUID = 2622464347110882879L;
    
    @Column(name = "user_id", nullable = false) 
    private Integer user;

    @Column(name = "book_id", nullable = false) 
    private Integer book;
 
}
