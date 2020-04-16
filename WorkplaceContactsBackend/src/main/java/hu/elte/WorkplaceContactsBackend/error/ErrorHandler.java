package hu.elte.WorkplaceContactsBackend.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandler {
    public String error;
    public String message;
}
