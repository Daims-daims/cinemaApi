package chat.Controller;

import chat.Model.Movie;
import chat.Repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public Iterable<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie){
        return this.movieRepository.save(movie);
    }
}
