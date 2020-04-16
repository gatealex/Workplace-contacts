package hu.elte.WorkplaceContactsBackend.lib;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import java.util.regex.*;

/**
 *
 * @author Alex
 */

public class PersonValidator  {
    
    static public boolean validate(Person person){
        boolean valid = Pattern.matches(
                "^([A-ZÖÜÓŐÚÉÁŰ][a-zöüóőúáű]{3,}\\s)+([A-ZÖÜÓŐÚÉÁŰ][a-zöüóőúáű]{3,})"
                , person.getName().trim());
        return valid;
    }
}
