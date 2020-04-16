/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.repositories;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emsgem
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query(value = "SELECT p FROM Person p WHERE p.name LIKE CONCAT('%',:name,'%')")
    List<Person> findByNameContaining(@Param("name") String name);
}
