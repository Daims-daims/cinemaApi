package chat.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=3,max=20,message = "Name must be between 3 and 20 characters")
    @Column(nullable = false,unique = true)
    private String name;

    @Min(value = 0,message = "Capacity must be greater than or equal to 0")
    @Max(value = 9999,message = "Capacity can't exceed 9999")
    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private Set<MovieSession> movieSessions;

    public Room(){}

    public Room(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }
}

