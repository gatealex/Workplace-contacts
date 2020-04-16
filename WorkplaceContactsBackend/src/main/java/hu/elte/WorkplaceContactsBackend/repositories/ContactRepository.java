package hu.elte.WorkplaceContactsBackend.repositories;

import hu.elte.WorkplaceContactsBackend.entities.Contact;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository  extends CrudRepository<Contact, Integer> {
    @Query(value = "SELECT c FROM Contact c WHERE c.contact LIKE CONCAT('%',:contact,'%')")
    List<Contact> findByContactContaining(@Param("contact") String contact);
    
    Optional<Contact> findByContact(String contact);
    
    void deleteByContact(String contact);
}
