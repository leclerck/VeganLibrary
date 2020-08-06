package cl.leclerck.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.leclerck.model.dao.ReviewDao;

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
    
	public Review postReview(Review review) {
		logger.info("Posting review: " + review.toString());
		return dao.save(review);
	}
	
	
}
