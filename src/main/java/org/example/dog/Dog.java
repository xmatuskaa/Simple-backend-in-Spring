package org.example.dog;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "Dog")
@Entity
public class Dog {
    @Id
    @SequenceGenerator(
            name = "dog_sequence",
            sequenceName = "dog_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "dog_sequence"
    )
    private Long id;
    private String name;
    private String breed;
    private LocalDate BirthDate;
    private String Gender;

    public Dog(String name, String breed, LocalDate BirthDate, String Gender){
        this.name = name;
        this.breed = breed;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
    }
    public Dog(){
    this.name = "Example";
    this.breed = "averageDog";
    this.BirthDate = LocalDate.now();
    this.Gender = "bitch";
    }

}
