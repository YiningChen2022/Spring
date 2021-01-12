package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonServices personServices;

    @Autowired
    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping
    public void addPerson(@NotNull @RequestBody Person person) {
        personServices.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personServices.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personServices.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personServices.deletePerson(id);
    }
    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NotNull @RequestBody Person personupdate){
        personServices.updatePerson(id,personupdate);
    }

}
