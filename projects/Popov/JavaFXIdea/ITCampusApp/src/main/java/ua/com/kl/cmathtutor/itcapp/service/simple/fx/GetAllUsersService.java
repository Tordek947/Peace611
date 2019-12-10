package ua.com.kl.cmathtutor.itcapp.service.simple.fx;

import com.google.common.collect.Lists;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.springframework.stereotype.Component;
import ua.com.kl.cmathtutor.itcapp.model.User;

import java.util.List;

@Component
public class GetAllUsersService extends Service<List<User>> {
    @Override
    protected Task<List<User>> createTask() {
        return new Task<List<User>>() {
            @Override
            protected List<User> call() throws Exception {
                return Lists.newArrayList(
                        User.builder().login("ungart").name("Alexey").surname("Stastkevich").build(),
                        User.builder().login("arangar999").name("Zeus").surname("Kronos").build());
            }
        };
    }
}
