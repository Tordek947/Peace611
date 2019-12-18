package ua.com.kl.cmathtutor.itcapp.service;

import ua.com.kl.cmathtutor.itcapp.exception.InvalidCredentialsException;
import ua.com.kl.cmathtutor.itcapp.exception.InvalidTokenException;
import ua.com.kl.cmathtutor.itcapp.model.AuthenticationToken;
import ua.com.kl.cmathtutor.itcapp.model.AuthorizedUser;
import ua.com.kl.cmathtutor.itcapp.model.Credentials;

/**
 * 
 * @author Hryhorii_Popov
 *
 */
public interface AuthenticationService {

    /**
     * Authenticate user using <code>credentials</code>
     * 
     * @param userCredentials User's login and password to authenticate by.
     * @return Authentication token for user if authentication was successful.
     * @throws InvalidCredentialsException if incorrect credentials were supplied
     */
    AuthenticationToken authenticateUser(Credentials userCredentials) throws InvalidCredentialsException;

    /**
     * Get currently authenticated user details based on its authentication token
     * 
     * @param authentication -- authentication token of currently authenticated user
     * @return User details (user model + user roles)
     * @throws InvalidTokenException if provided authentication token was invalid.
     */
    AuthorizedUser getAuthorizedUser(AuthenticationToken authentication) throws InvalidTokenException;
}
