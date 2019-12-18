package ua.com.kl.cmathtutor.itcapp.service;

import java.util.List;

import javafx.concurrent.Service;
import javafx.scene.image.Image;
import ua.com.kl.cmathtutor.itcapp.model.User;

/**
 * Service to manage users. The general concept of services in this app is that
 * it contains business-logic methods (i.e. {@link #getAllUsers()}) as well as
 * the same methods but with 'Service' suffix, which return javaFX
 * {@link Service} to call this service business-logic methods asynchronously
 * from JavaFX thread.
 * 
 * @author Hryhorii_Popov
 *
 */
public interface UserService {
    /**
     * 
     * @return list of all users currently existed within system.
     */
    List<User> getAllUsers();

    /**
     * Get user avatar image by provided login
     * 
     * @param login user login to get avatar by
     * @return {@link Image} contains user avatar image if user with specified login
     *         is present in the system.
     */
    Image getUserAvatarImageByLogin(String login);

    /**
     * 
     * @return JavaFX {@link Service} for {@link #getAllUsers()}
     */
    Service<List<User>> getAllUsersService();

    /**
     * 
     * @param login see {@link #getUserAvatarImageByLogin(String)}
     * @return JavaFX {@link Service} for {@link #getUserAvatarImageByLogin(String)}
     */
    Service<Image> getUserAvatarImageByLoginService(String login);
}
