package ua.com.kl.cmathtutor.itcapp.service.simple;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ua.com.kl.cmathtutor.itcapp.exception.InvalidCredentialsException;
import ua.com.kl.cmathtutor.itcapp.model.AuthenticationToken;
import ua.com.kl.cmathtutor.itcapp.model.Credentials;

public class SimpleAuthenticationServiceTest {

    private SimpleAuthenticationService service;

    @BeforeEach
    void setUp() {
        service = new SimpleAuthenticationService();
    }

    @Test
    void whenCredentialsAreInvalid_Then_authenticateUser_shouldThrowException() {
        String login = "admin";
        String invalidPassword = "namda";
        Credentials credentials = Credentials.builder().username(login).password(invalidPassword).build();
        assertThrows(InvalidCredentialsException.class, () -> service.authenticateUser(credentials));
    }

    @ParameterizedTest(name = "Credentials with login {0} and password {1} have to be valid!")
    @CsvSource({"ungart, dragun",
            "arangar999, qwertyuiop_01925",
            "admin, nimda"})
    void whenCredentialsAreValid_Then_authenticateUser_ShouldReturnAuthenticationToken(String login, String password)
            throws InvalidCredentialsException {
        Credentials credentials = new Credentials(login, password);
        AuthenticationToken actual = service.authenticateUser(credentials);
        assertNotNull(actual);
        assertThat(actual.getUsername(), is(equalTo(credentials.getUsername())));
    }

}
