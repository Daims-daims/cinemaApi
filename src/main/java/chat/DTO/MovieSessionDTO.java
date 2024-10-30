package chat.DTO;

import java.util.Date;

public class MovieSessionDTO {

    private Integer roomId;
    private Integer movieId;
    private Date startSession;

    public MovieSessionDTO() {
    }

    public MovieSessionDTO(Integer roomId, Integer movieId, Date startSession) {
        this.roomId = roomId;
        this.movieId = movieId;
        this.startSession = startSession;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Date getStartSession() {
        return startSession;
    }

    @Override
    public String toString() {
        return "MovieSessionDTO{" +
                "roomId=" + roomId +
                ", movieId=" + movieId +
                ", startSession=" + startSession +
                '}';
    }
}
