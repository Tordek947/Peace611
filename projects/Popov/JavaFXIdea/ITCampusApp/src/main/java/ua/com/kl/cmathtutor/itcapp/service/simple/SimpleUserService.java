package ua.com.kl.cmathtutor.itcapp.service.simple;

import com.google.common.collect.Lists;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kl.cmathtutor.itcapp.model.User;
import ua.com.kl.cmathtutor.itcapp.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleUserService implements UserService {

    @Override
    public List<User> getAllUsers() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList(
                User.builder().login("ungart").name("Alexey").surname("Stastkevich").build(),
                User.builder().login("arangar999").name("Zeus").surname("Kronos").build());
    }

    @Override
    public Image getUserAvatarImageByLogin(String login) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Image image = new Image(login + ".png");
        return image;
    }

    @Override
    public javafx.concurrent.Service<List<User>> getAllUsersService() {
        return new GetAllUsersService();
    }

    @Override
    public javafx.concurrent.Service<Image> getUserAvatarImageByLoginService(String login) {
        return new GetUserAvatarImageByLoginService(login);
    }

    private class GetAllUsersService extends javafx.concurrent.Service<List<User>> {
        @Override
        protected Task<List<User>> createTask() {
            return new Task<List<User>>() {
                @Override
                protected List<User> call() throws Exception {
                    return getAllUsers();
                }
            };
        }
    }

    @AllArgsConstructor
    private class GetUserAvatarImageByLoginService extends javafx.concurrent.Service<Image> {

        private String login;

        @Override
        protected Task<Image> createTask() {
            return new Task<Image>() {
                @Override
                protected Image call() throws Exception {
                    return getUserAvatarImageByLogin(login);
                }
            };
        }
    }
}
