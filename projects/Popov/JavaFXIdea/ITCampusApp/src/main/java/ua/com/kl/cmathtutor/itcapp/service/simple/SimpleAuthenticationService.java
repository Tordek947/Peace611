package ua.com.kl.cmathtutor.itcapp.service.simple;

import org.springframework.stereotype.Service;
import ua.com.kl.cmathtutor.itcapp.exception.InvalidCredentialsException;
import ua.com.kl.cmathtutor.itcapp.exception.InvalidTokenException;
import ua.com.kl.cmathtutor.itcapp.model.AuthenticationToken;
import ua.com.kl.cmathtutor.itcapp.model.AuthorizedUser;
import ua.com.kl.cmathtutor.itcapp.model.Credentials;
import ua.com.kl.cmathtutor.itcapp.service.AuthenticationService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SimpleAuthenticationService implements AuthenticationService {

    private Map<Credentials, AuthenticationToken> credentialsToAuthToken;

    public SimpleAuthenticationService() {
        credentialsToAuthToken = new HashMap<>();
        credentialsToAuthToken.put(new Credentials("ungart", "dragun"),
                AuthenticationToken.builder().username("ungart").build());
        credentialsToAuthToken.put(new Credentials("arangar999", "qwertyuiop_01925"),
                AuthenticationToken.builder().username("arangar999").build());
        credentialsToAuthToken.put(new Credentials("admin", "nimda"),
                AuthenticationToken.builder().username("admin").build());
    }

    @Override
    public AuthenticationToken authenticateUser(Credentials userCredentials) throws InvalidCredentialsException {
        AuthenticationToken authenticationToken = credentialsToAuthToken.get(userCredentials);
        if (Objects.nonNull(authenticationToken)) {
            return authenticationToken;
        }
        throw new InvalidCredentialsException();
    }

    @Override
    public AuthorizedUser getAuthorizedUser(AuthenticationToken authentication) throws InvalidTokenException {
        return null;
    }
}
