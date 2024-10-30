package chat.Runner;

import chat.Model.Movie;
import chat.Model.Room;
import chat.Model.User;
import chat.Repository.MovieRepository;
import chat.Repository.RoomRepository;
import chat.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   MovieRepository movieRepository,
                                   RoomRepository roomRepository) {

        return _ -> {
            log.info("Preloading user " +
                    userRepository.save(new User("Jean-Marie","Poiré", LocalDate.of(1945, Month.JULY, 27)))  +
                    userRepository.save(new User("Jacques","Audiard", LocalDate.of(1952, Month.APRIL, 30))));
            log.info("Preloading movie " +
                    movieRepository.save(new Movie("LotR", 175)) +
                    movieRepository.save(new Movie("Star Wars", 155)) +
                    movieRepository.save(new Movie("Harry Potter", 95)));
            log.info("Preloading room " + roomRepository.save(new Room("Salle principale", 240)) +
                    roomRepository.save(new Room("Salle secondaire", 180)) +
                    roomRepository.save(new Room("Salle film d'auteur", 60)) +
                    roomRepository.save(new Room("Salle comédie", 100)));

        };
    }
}