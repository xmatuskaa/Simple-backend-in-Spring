package org.example.dog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration

public class DogConfig {
    @Bean
    CommandLineRunner commandLineRunner(DogRepository dogRepository){
        return  args -> {
          Dog Cheddar = new Dog("Cheddar","Corgi",LocalDate.of(2012, Month.AUGUST,9),"Dog");
          Dog Biscuit = new Dog("Biscuit","Golden retriever",LocalDate.of(2016, Month.JUNE,15),"Dog");
          Dog Beans = new Dog("Beans","Badger dog",LocalDate.of(2010, Month.JANUARY,2),"Bitch");

        dogRepository.saveAll(List.of(Beans,Cheddar,Biscuit));
        };
    }
}
