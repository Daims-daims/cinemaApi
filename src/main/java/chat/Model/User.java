package chat.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;


import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @Past(message = "User can't be born in the future")
    private LocalDate dateOfBirth;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public User() {}

    public User(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}