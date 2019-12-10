package ua.com.kl.cmathtutor.itcapp.service;

import javafx.scene.image.Image;
import ua.com.kl.cmathtutor.itcapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Image getUserAvatarImageByLogin(String login);
}
