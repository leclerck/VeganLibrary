package cl.leclerck.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.leclerck.model.dao.ReviewDao;
import cl.leclerck.model.entity.Book;
import cl.leclerck.model.entity.BookCustomer;
import cl.leclerck.model.entity.Customer;
import cl.leclerck.model.entity.Review;

@Service
public class ReviewService {
	private final Logger logger = LoggerFactory.getLogger(ReviewService.class);
	
    @Autowired
    private ReviewDao dao;
    
    @Transactional(readOnly = true)
    public List<Review> getAll(){
        return dao.findAll();
    }
    
	public Review postReview(Review review, BookCustomer bc) {
		logger.info("Posting review: " + review.toString());
		review.setId(bc);
		return dao.save(review);
	}
	
	public void addReview(BookCustomer bc, Review review) {
		Book book = new Book();
		Customer customer = new Customer();
		book.setId(bc.getBook());
		customer.setId(bc.getCustomer());
		
		if(book.getReviews() != null || customer.getReviews()!=null ) {
			book.getReviews().add(review);
			customer.getReviews().add(review);
		}else {
			logger.warn("Couldn't add review");
		}
	}
	
}
