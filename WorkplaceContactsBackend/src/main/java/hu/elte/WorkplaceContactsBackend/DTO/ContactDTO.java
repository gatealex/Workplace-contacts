package hu.elte.WorkplaceContactsBackend.DTO;

import hu.elte.WorkplaceContactsBackend.keys.ContactKey.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Integer id;
    private ContactType contactType;
    private String contact;
}
