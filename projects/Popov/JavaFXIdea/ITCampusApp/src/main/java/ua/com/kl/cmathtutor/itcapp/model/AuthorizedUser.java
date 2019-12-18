package ua.com.kl.cmathtutor.itcapp.model;

import java.util.EnumSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.kl.cmathtutor.itcapp.service.AuthenticationService;

/**
 * Is used within {@link AuthenticationService} to get currently authenticated
 * user.
 * 
 * @author Hryhorii_Popov
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizedUser {
    private String login;
    private String name;
    private String surname;
    private EnumSet<AuthorityType> authorities;
}
