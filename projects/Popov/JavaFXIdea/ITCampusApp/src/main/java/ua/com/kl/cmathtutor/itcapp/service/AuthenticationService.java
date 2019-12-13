package ua.com.kl.cmathtutor.itcapp.service;

import ua.com.kl.cmathtutor.itcapp.exception.InvalidCredentialsException;
import ua.com.kl.cmathtutor.itcapp.exception.InvalidTokenException;
import ua.com.kl.cmathtutor.itcapp.model.AuthenticationToken;
import ua.com.kl.cmathtutor.itcapp.model.AuthorizedUser;
import ua.com.kl.cmathtutor.itcapp.model.Credentials;

public interface AuthenticationService {

    AuthenticationToken authenticateUser(Credentials userCredentials) throws InvalidCredentialsException;

    AuthorizedUser getAuthorizedUser(AuthenticationToken authentication) throws InvalidTokenException;
}
