package ua.com.kl.cmathtutor.itcapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model to store user login and password
 * @author Hryhorii_Popov
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
    private String username;
    private String password;
}
