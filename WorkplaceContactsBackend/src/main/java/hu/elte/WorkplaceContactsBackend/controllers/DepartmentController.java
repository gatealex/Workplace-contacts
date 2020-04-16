/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Department;
import hu.elte.WorkplaceContactsBackend.entities.Person;
import hu.elte.WorkplaceContactsBackend.lib.DepartmentValidator;
import hu.elte.WorkplaceContactsBackend.repositories.DepartmentRepository;
import hu.elte.WorkplaceContactsBackend.repositories.PersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired PersonRepository peopleRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Department>> getAll() {
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @GetMapping(path = "/findByName", consumes = "application/json")
    public ResponseEntity<Iterable<Department>> getByNameContaining(@RequestBody Department department) {
        return ResponseEntity.ok(departmentRepository.findByName(department.getName()));
    }

    //Ide kérek ellenőrzéseket
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Department> post(@RequestBody Department department) {
        if(!DepartmentValidator.validate(department)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Department newDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(newDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> put(@RequestBody Department person, @PathVariable Integer id) {
        Optional<Department> oPerson = departmentRepository.findById(id);
        if (oPerson.isPresent()) {
            person.setId(id);
            return ResponseEntity.ok(departmentRepository.save(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Department> oMessage = departmentRepository.findById(id);
        if (oMessage.isPresent()) {
            departmentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/{id}/{personId}")
    public ResponseEntity addPerson(@PathVariable Integer id, @PathVariable Integer personId) {
        Optional<Person> oPerson = peopleRepository.findById(personId);
        if(oPerson.isPresent()) {
            Optional<Department> oDepartment = departmentRepository.findById(id);
            if(oDepartment.isPresent()) {
                Person person = oPerson.get();
                Department department = oDepartment.get();
                person.getDepartments().add(department);
                department.getPeople().add(person);
                departmentRepository.save(department);
                return ResponseEntity.ok(department);
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
