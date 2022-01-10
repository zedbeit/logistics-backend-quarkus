package org.miles.useraccount.representation;

import java.time.Instant;
import org.miles.useraccount.entity.UserAccount;

public class UserAccountRepresentation {
    public String email;
    public Instant createdOn;
    
    public UserAccountRepresentation(UserAccount userAccount) {
        email = userAccount.email;
        createdOn = userAccount.createdDate;
    }
}
