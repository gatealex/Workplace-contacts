package hu.elte.WorkplaceContactsBackend.lib;

import hu.elte.WorkplaceContactsBackend.entities.Department;
import java.util.regex.*;
/**
 *
 * @author Alex
 */
public class DepartmentValidator {
    
    static public boolean validate(Department department){
    boolean valid = Pattern.matches(
                "^([A-Z][a-z]+){3,}"
                , department.getName().trim());
    return valid;
    }
    
}
