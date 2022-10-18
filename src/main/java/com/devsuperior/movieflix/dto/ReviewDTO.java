package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO {

	private Long id;
	
	@NotBlank
	private String text;
	private Long movieId;
	private UserInsertDTO user = new UserInsertDTO();
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text,Long movieId, UserInsertDTO user) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.user = user;
	}
	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movieId = entity.getMovie().getId();
		user.setId(entity.getUser().getId());
		user.setName(entity.getUser().getName());
		user.setEmail(entity.getUser().getEmail());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public UserInsertDTO getUser() {
		return user;
	}

	public void setUser(UserInsertDTO user) {
		this.user = user;
	}
	
}
