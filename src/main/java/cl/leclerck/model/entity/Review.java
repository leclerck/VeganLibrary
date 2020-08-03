package cl.leclerck.model.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Review {

    @EmbeddedId
    private BookCustomer id;

    private String title;
    private double stars;
    private Date date;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("customer_id")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;
    
}
