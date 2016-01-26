package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.MovieDao;
import superheroApp.superheroApp.entities.Movie;
import superheroApp.superheroApp.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;

	public void updateMovie(Movie movie) {
		movieDao.updateMovie(movie);
	}

	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

	public Movie getMovieById(int id) {
		return movieDao.getMovieById(id);
	}

	public void createMovie(Movie movie) {
		movieDao.createMovie(movie);
		
	}

	public void delete(int id) {
		movieDao.delete(id);
	}
}
