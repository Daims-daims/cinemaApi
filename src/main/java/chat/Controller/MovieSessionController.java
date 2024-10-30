package chat.Controller;

import chat.DTO.MovieSessionDTO;
import chat.Model.MovieSession;
import chat.Service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MovieSessionController {

    @Autowired
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/movieSessions")
    public Iterable<MovieSession> getAllMovieSession(){
        return movieSessionService.findAll();
    }

    @PostMapping("/movieSessions")
    public ResponseEntity<MovieSession> createMovieSession(@RequestBody MovieSessionDTO movieSessionRequest){
        final Optional<MovieSession> movieSession = movieSessionService.translateDTO(movieSessionRequest);

        if(movieSession.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        if(! movieSessionService.checkOverLapMovieSession(movieSession.get())){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(movieSessionService.save(movieSession.get()));
    }
}
