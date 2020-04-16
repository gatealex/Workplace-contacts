package hu.elte.WorkplaceContactsBackend.keys;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import java.io.Serializable;

public class ContactKey implements Serializable  {
    private Person person;
    private ContactType contactType;
    private String contact;
    
    
    public enum ContactType {
        TELEPHONE, MOBILE_PHONE, EMAIL
    }
}


