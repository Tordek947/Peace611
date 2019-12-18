package ua.com.kl.cmathtutor.itcapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This model is used to store auth token information for currently authenticated user.
 * @author Hryhorii_Popov
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationToken {
    private String username;
    private String token;
}
