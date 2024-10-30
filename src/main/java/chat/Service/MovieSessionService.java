package chat.Service;

import chat.DTO.MovieSessionDTO;
import chat.Model.Movie;
import chat.Model.MovieSession;
import chat.Model.Room;
import chat.Repository.MovieRepository;
import chat.Repository.MovieSessionRepository;
import chat.Repository.RoomRepository;
import chat.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSessionService {

    @Autowired
    private final MovieSessionRepository movieSessionRepository;
    @Autowired
    private final RoomRepository roomRepository;
    @Autowired
    private final MovieRepository movieRepository;

    public MovieSessionService(MovieSessionRepository movieSessionRepository, RoomRepository roomRepository, MovieRepository movieRepository) {
        this.movieSessionRepository = movieSessionRepository;
        this.roomRepository = roomRepository;
        this.movieRepository = movieRepository;
    }

    public Optional<MovieSession> translateDTO(MovieSessionDTO movieSessionDTO){
        // Room search
        final Optional<Room> room = roomRepository.findById(movieSessionDTO.getRoomId());
        if(room.isEmpty()){
            return Optional.empty();
        }
        // Movie search
        final Optional<Movie> movie = movieRepository.findById(movieSessionDTO.getMovieId());
        if(movie.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(new MovieSession(movieSessionDTO.getStartSession(),room.get(),movie.get()));
    }

    public boolean checkOverLapMovieSession(MovieSession movieSession){
        // MovieSession for requested room search
        final List<MovieSession> movieSessionInRoom = movieSessionRepository.findByRoomId(movieSession.getRoom().getId());

        if(!movieSessionInRoom.isEmpty()){

            // Search for MovieSession with overlap
            List<MovieSession> listOverlapMovieSession = movieSessionInRoom.stream().filter(
                    movieSessionAll -> DateUtil.isDateInInterval(movieSession.getStartSession(),movieSessionAll.getStartSession(),movieSessionAll.getMovie().getMovieLength())
                            || DateUtil.isDateInInterval(movieSessionAll.getStartSession(),movieSession.getStartSession(),movieSession.getMovie().getMovieLength())
            ).toList();

            if(! listOverlapMovieSession.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public MovieSession save(MovieSession movieSession){
        return movieSessionRepository.save(movieSession);
    }

    public Iterable<MovieSession> findAll(){
        return movieSessionRepository.findAll();
    }

}
