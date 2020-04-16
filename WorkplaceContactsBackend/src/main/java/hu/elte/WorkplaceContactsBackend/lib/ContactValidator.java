package hu.elte.WorkplaceContactsBackend.lib;

import hu.elte.WorkplaceContactsBackend.entities.Contact;
import java.util.regex.*;
/**
 *
 * @author Alex
 */
public class ContactValidator {
    
    static public boolean validateEmail(Contact contact){
        boolean valid = Pattern.matches(
                "^[A-ZÖÜÓŐÚÁŰ0-9a-zöüóőúáű._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"
                , contact.getContact().trim());
        return valid;
    }
    
    static public boolean validateMobilePhone(Contact contact){
        boolean valid = Pattern.matches(
                "^[+]?[0-9 ]{6,20}"
                , contact.getContact().trim());
        return valid;
    }
    
    static public boolean validateTelephone(Contact contact){
        boolean valid = Pattern.matches(
                "^[+]?[0-9 ]{6,20}"
                , contact.getContact().trim());
        return valid;
    }
}
