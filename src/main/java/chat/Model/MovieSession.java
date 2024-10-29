package chat.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movieSessions")
public class MovieSession {

    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Future(message = "Session must be in future")
    private Date startSession; // start of session in minutes

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roomId")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movieId")
    private Movie movie;

}
