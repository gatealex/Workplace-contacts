package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Department;
import hu.elte.WorkplaceContactsBackend.entities.Person;
import hu.elte.WorkplaceContactsBackend.lib.PersonValidator;
import hu.elte.WorkplaceContactsBackend.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.WorkplaceContactsBackend.repositories.PersonRepository;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository peopleRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Person>> getAll() {
        return ResponseEntity.ok(peopleRepository.findAll());
    }
    
    @GetMapping(path = "/findByName", consumes = "application/json")
    public ResponseEntity<Iterable<Person>> getByNameContaining(@RequestBody Person person) { 
        return ResponseEntity.ok(peopleRepository.findByNameContaining(person.getName()));
    }
    
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> post(@RequestBody Person person) {
        if(!PersonValidator.validate(person)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Person newPerson = peopleRepository.save(person);
        return ResponseEntity.ok(newPerson);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Person> put(@RequestBody Person person, @PathVariable Integer id) {
        Optional<Person> oPerson = peopleRepository.findById(id);
        if (oPerson.isPresent()) {
            person.setId(id);
            return ResponseEntity.ok(peopleRepository.save(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Person> oMessage = peopleRepository.findById(id);
        if (oMessage.isPresent()) {
            peopleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/{id}/{departmentId}")
    public ResponseEntity addDepartment(@PathVariable Integer id, @PathVariable Integer departmentId) {
        Optional<Person> oPerson = peopleRepository.findById(id);
        if(oPerson.isPresent()) {
            Optional<Department> oDepartment = departmentRepository.findById(departmentId);
            if(oDepartment.isPresent()) {
                Person person = oPerson.get();
                Department department = oDepartment.get();
                person.getDepartments().add(department);
                department.getPeople().add(person);
                peopleRepository.save(person);
                return ResponseEntity.ok(person);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
