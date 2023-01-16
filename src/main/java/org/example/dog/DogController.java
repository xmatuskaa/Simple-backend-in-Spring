package org.example.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/dogs")
public class DogController {
    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService){
        this.dogService = dogService;
    }


    @DeleteMapping(path="/{id}")
    public void deleteDog(@PathVariable("id") Long id){
        dogService.deleteDog(id);
    }

    @GetMapping
    public List<Dog> getDogs(){return dogService.getDogs();}

    @GetMapping(path = "{/id}")
    public Optional<Dog> getDogById(@PathVariable("id") Long id){
        return dogService.getDogById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDog(@RequestBody Dog dog){
        dogService.addDog(dog);
    }

    @PutMapping(path = "{id}")
    public void updateDog(@PathVariable("id") Long id,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String gender,
                          @RequestParam(required = false) String breed){
        dogService.updateDog(id,name,gender,breed);
    }
}
