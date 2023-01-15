package org.example.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
private final DogRepository dogRepository;

@Autowired
    public DogService(DogRepository dogRepository){
    this.dogRepository = dogRepository;
}


public void addDog(Dog dog){
    dogRepository.save(dog);
}
public List<Dog> getDogs(){
    return dogRepository.findAll();
}

public void deleteDog(Long id){
    if(dogRepository.existsById(id)){
        dogRepository.deleteById(id);
    }
    else throw new IllegalStateException("wrong id");
}

public void updateDog(Long id, String name, String gender, String breed){
    Dog dog = dogRepository.findById(id).orElseThrow();
        if(name.length()>0){
            dog.setName(name);
        }
        if(gender.length()>0){
            dog.setGender(gender);
        }
        if(breed.length()>0){
            dog.setGender(breed);
        }
    }
}
