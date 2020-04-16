/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Admin;
import hu.elte.WorkplaceContactsBackend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.WorkplaceContactsBackend.repositories.AdminRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Attila
 */

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminsRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Admin>> getAll() {
        return ResponseEntity.ok(adminsRepository.findAll());
    }
    
    @PostMapping("/new")
    public ResponseEntity<Admin> post(@RequestBody Admin admin) {
        Admin newAdmin = adminsRepository.save(admin);
        return ResponseEntity.ok(newAdmin);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Admin> put(@RequestBody Admin person, @PathVariable Integer id) {
        Optional<Admin> oPerson = adminsRepository.findById(id);
        if (oPerson.isPresent()) {
            person.setId(id);
            return ResponseEntity.ok(adminsRepository.save(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Admin> oMessage = adminsRepository.findById(id);
        if (oMessage.isPresent()) {
            adminsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
