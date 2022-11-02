package com.example.jo.controller;

import com.example.jo.model.Person;
import com.example.jo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PersonController {

    @Autowired
    PersonRepo repo;

    @GetMapping("all")
    public List<Person> getAll() {
        return repo.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Person> getById(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @GetMapping("/{name}")
    public Optional<Person> getByName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @GetMapping("/count/{age}")
    public Integer countByAge(@PathVariable Integer age) {
        return repo.countAllByAge(age);
    }

    @GetMapping("/select/{age}/{name}")
    public Optional<Person> select(@PathVariable Integer age, @PathVariable String name) {
        return repo.select(age,name);
    }



    @PostMapping
    public Person add(@RequestBody Person person) {
        return repo.save(person);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
    @PutMapping
    public Person put(@RequestBody Person person) {
        return repo.save(person);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void DB(){

        repo.save(new Person(1,"tomek","byk",34));
        repo.save(new Person(4,"przemek","noc",24));


    }

}
