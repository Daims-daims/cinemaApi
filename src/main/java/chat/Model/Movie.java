package chat.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name= "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=3,max=25,message = "Name must be between 3 and 25 characters")
    private String name;

    @Min(value = 60,message = "Movie must be at least 60 minutes")
    @Max(value = 240,message = "Movie can't exceed 240 minutes")
    private Integer movieLength; // movie length in minutes

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private Set<MovieSession> movieSessions;

    public Movie(){}

    public Movie(String name,Integer movieLength){
        this.name = name;
        this.movieLength = movieLength;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMovieLength() {
        return movieLength;
    }
}
