package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import superheroApp.superheroApp.entities.Movie;
import superheroApp.superheroApp.services.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;;

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public Movie getMovieById(@PathVariable int id) {
		return movieService.getMovieById(id);
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		movieService.delete(id);
	}
	
	@RequestMapping(value = "/movie", method = RequestMethod.PUT)
	public void updateMovie(@RequestBody Movie movie) {
		movieService.updateMovie(movie);
	}
	
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public void createMovie(@RequestBody Movie movie) {
		movieService.createMovie(movie);
	}
}
