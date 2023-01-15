package org.example.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query("SELECT d FROM Dog d WHERE d.name = ?1")
    Optional<Dog> findDogByName(String name);

    @Query("SELECT d FROM Dog d WHERE d.id = ?1")
    Optional<Dog> findDogById(Long id);
}
