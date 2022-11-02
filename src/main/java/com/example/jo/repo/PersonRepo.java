package com.example.jo.repo;

import com.example.jo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {

    Optional<Person> findByName(String name);
    Integer countAllByAge(Integer age);

    @Query("SELECT p from Person p where p.age = ?1 and p.name = ?2")
    Optional<Person> select(Integer age,String name);


}
