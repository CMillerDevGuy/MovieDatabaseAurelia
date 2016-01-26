package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.Movie;

public interface MovieService {

	void updateMovie(Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieById(int id);

	void createMovie(Movie movie);

	void delete(int id);

}
