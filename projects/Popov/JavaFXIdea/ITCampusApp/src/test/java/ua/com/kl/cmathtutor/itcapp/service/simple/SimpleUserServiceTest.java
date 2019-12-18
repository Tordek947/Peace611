package ua.com.kl.cmathtutor.itcapp.service.simple;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ua.com.kl.cmathtutor.itcapp.model.User;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleUserServiceTest {

    private SimpleUserService service;

    @BeforeEach
    void setUp() {
        service = new SimpleUserService();
    }

    @Test
    void getAllUsers_Should_ExecuteAtLeast_2_Seconds() {
        long before = System.currentTimeMillis();
        service.getAllUsers();
        long after = System.currentTimeMillis();

        assertThat(Long.valueOf(after - before), is(greaterThanOrEqualTo(2000L)));
    }

    @Test
    void getAllUsers_Should_ReturnUsers() {

        List<User> allUsers = service.getAllUsers();

        assertNotNull(allUsers);
        assertAll(() -> assertThat(allUsers.size(), is(equalTo(2))),
                () -> assertThat(allUsers.get(0).getLogin(), is(equalTo("ungart"))),
                () -> assertThat(allUsers.get(1).getLogin(), is(equalTo("arangar999"))));
    }

    @Test
    void getUserAvatarImageByLogin_Should_ExecuteAtLeast_2_Seconds() {
        String login = "login";
        long before = System.currentTimeMillis();
        try {
            service.getUserAvatarImageByLogin(login);
        } catch (RuntimeException e) {
            //Nothing to do, we don't test the actual result here.
        }
        long after = System.currentTimeMillis();

        assertThat(Long.valueOf(after - before), is(greaterThanOrEqualTo(2000L)));
    }

    @ParameterizedTest
    @CsvSource({"ungart", "arangar999"})
    void whenUserWithSpecifiedLoginExists_Then_getUserAvatarImageByLogin_Should_ReturnImage(String login) {
        RuntimeException unitializedInternalGraphicException = null;
        try {
            service.getUserAvatarImageByLogin(login);
        } catch (RuntimeException e) {
            unitializedInternalGraphicException = e;
        }
        assertNotNull(unitializedInternalGraphicException);
        assertThat(unitializedInternalGraphicException.getMessage(), is(equalTo("Internal graphics not initialized yet")));
    }

    @Test
    void whenUserWithSpecifiedLogin_Not_Exists_Then_getUserAvatarImageByLogin_Should_ThrowException() {
        String unexistedLogin = "someUnexistedLoginnnnn";

        assertThrows(IllegalArgumentException.class, () -> service.getUserAvatarImageByLogin(unexistedLogin));
    }
}
