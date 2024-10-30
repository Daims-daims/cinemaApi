package chat.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import java.util.Date;

@Entity
@Table(name = "movieSessions")
public class MovieSession {


    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Future(message = "Session must be in future")
    private Date startSession; // start of session in minutes

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name="roomId",nullable = false)
    private Room room;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name="movieId",nullable = false)
    private Movie movie;

    public MovieSession() {}

    public MovieSession(Date startSession, Room room, Movie movie) {
        this.startSession = startSession;
        this.room = room;
        this.movie = movie;
    }

    public @Future(message = "Session must be in future") Date getStartSession() {
        return startSession;
    }

    public Integer getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Movie getMovie() {
        return movie;
    }
}
