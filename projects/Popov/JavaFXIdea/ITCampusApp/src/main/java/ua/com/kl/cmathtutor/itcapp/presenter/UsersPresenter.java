package ua.com.kl.cmathtutor.itcapp.presenter;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ua.com.kl.cmathtutor.itcapp.GluonApplication;
import ua.com.kl.cmathtutor.itcapp.component.UserTileComponent;
import ua.com.kl.cmathtutor.itcapp.model.User;
import ua.com.kl.cmathtutor.itcapp.service.UserService;
import ua.com.kl.cmathtutor.itcapp.service.simple.fx.GetAllUsersService;

import java.util.List;

@Controller
public class UsersPresenter {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserService userService;

    @FXML
    private CardPane<HBox> userTiles;
    @FXML
    private View usersView;
    @FXML
    private ProgressIndicator reloadSpinner;


    @FXML
    private Label label;

    public void initialize() {
        usersView.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Users");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e ->
                        System.out.println("Search")));

                GetAllUsersService getAllUsersService = new GetAllUsersService();
                getAllUsersService.setOnSucceeded(this::onGetAllUsersSucceed);
                getAllUsersService.start();
            }
        });
    }

    private void onGetAllUsersSucceed(WorkerStateEvent workerStateEvent) {
        List<User> users = (List<User>) workerStateEvent.getSource().getValue();
        users.forEach(this::addUserTile);
    }

    private void addUserTile(User user) {
        UserTileComponent userTile = applicationContext.getBean(UserTileComponent.class);
        userTile.getUsernameLabel().setText(user.getLogin());
        userTile.getFullNameLabel().setText(user.getSurname() + " " + user.getName());
//        userTile.getAvatar().setImage(userService.getUserAvatarImageByLogin(user.getLogin()));
        userTile.getRoot().setOnMouseClicked(this::onUserTileClicked);
        userTiles.getItems().add(userTile.getRoot());
    }

    private void onUserTileClicked(MouseEvent mouseEvent) {
        MobileApplication.getInstance().switchView(GluonApplication.USER_PROFILE_VIEW);
    }

    @FXML
    void reloadUsers() {
    }

}
