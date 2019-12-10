package ua.com.kl.cmathtutor.itcapp.service.simple;

import com.google.common.collect.Lists;
import javafx.scene.image.Image;
import org.springframework.stereotype.Service;
import ua.com.kl.cmathtutor.itcapp.model.User;
import ua.com.kl.cmathtutor.itcapp.service.UserService;

import java.net.URI;
import java.util.List;

@Service
public class SimpleUserService implements UserService {

    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(
                User.builder().login("ungart").name("Alexey").surname("Stastkevich").build(),
                User.builder().login("arangar999").name("Zeus").surname("Kronos").build());
    }

    @Override
    public Image getUserAvatarImageByLogin(String login) {
        Image image = new Image(SimpleUserService.class.getResourceAsStream(login + ".png"));
        return image;
    }
}
