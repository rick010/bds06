package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(nativeQuery = true, value = "SELECT * "
			+ "FROM tb_movie INNER JOIN tb_genre "
			+ "ON tb_movie.genre_id = tb_genre.id "
			+ "WHERE tb_genre.id = :genreId "
			+ "ORDER BY tb_movie.title ASC")
	Page<Movie> findMovieGenre(Long genreId, Pageable pageable);

	@Query(nativeQuery = true, value = "SELECT * "
			+ "FROM tb_movie INNER JOIN tb_genre "
			+ "ON tb_movie.genre_id = tb_genre.id "
			+ "ORDER BY  tb_movie.title ASC")
	Page<Movie> findMovies(Pageable pageable);
}
