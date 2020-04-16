package hu.elte.WorkplaceContactsBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.WorkplaceContactsBackend.keys.ContactKey;
import hu.elte.WorkplaceContactsBackend.keys.ContactKey.ContactType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(ContactKey.class)
public class Contact {
    @Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Person person;
    
    @Id
    @Column(name = "contact_type")
    private ContactType contactType;
    
    @Id
    @Column
    private String contact;
}
