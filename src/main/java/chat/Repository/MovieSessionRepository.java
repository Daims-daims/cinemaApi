package chat.Repository;

import chat.Model.MovieSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSessionRepository extends JpaRepository<MovieSession,Integer> {

    List<MovieSession> findByRoomId(Integer roomId);

}
