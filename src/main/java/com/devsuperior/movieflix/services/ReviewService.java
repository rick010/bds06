package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository repository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	AuthService authService;
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		authService.validateMember();
		Review entity = new Review();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}
	
	public ReviewDTO copyDtoToEntity(ReviewDTO dto, Review entity) {
		User user = authService.authenticated();
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		entity.setText(dto.getText());
		entity.setMovie(movie);
		entity.setUser(user);
		return new ReviewDTO(entity);
	}

}
