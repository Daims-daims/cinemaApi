package chat.Controller;

import chat.Model.Room;
import chat.Repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public Iterable<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody @Valid Room room){
        return this.roomRepository.save(room);
    }
}
