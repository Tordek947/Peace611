package ua.com.kl.cmathtutor.itcapp.presenter;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import ua.com.kl.cmathtutor.itcapp.GluonApplication;
import ua.com.kl.cmathtutor.itcapp.component.UserTileComponent;
import ua.com.kl.cmathtutor.itcapp.model.User;
import ua.com.kl.cmathtutor.itcapp.service.UserService;

import java.util.List;

@Controller
public class UsersPresenter {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserService userService;
    @Autowired
    private UserProfilePresenter userProfilePresenter;

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

                reloadUsers();
            }
        });
    }

    private void onGetAllUsersSucceed(WorkerStateEvent workerStateEvent) {
        List<User> users = (List<User>) workerStateEvent.getSource().getValue();
        users.forEach(this::addUserTile);
        reloadSpinner.progressProperty().unbind();
        reloadSpinner.setVisible(false);
    }

    private void addUserTile(User user) {
        UserTileComponent userTile = applicationContext.getBean(UserTileComponent.class);
        userTile.getUsernameLabel().setText(user.getLogin());
        userTile.getFullNameLabel().setText(user.getSurname() + " " + user.getName());
        Service<Image> getUserAvatarImageByLoginService = userService.getUserAvatarImageByLoginService(user.getLogin());
        userTile.getAvatarLoadingIndicator().progressProperty().bind(getUserAvatarImageByLoginService.progressProperty());
        getUserAvatarImageByLoginService.setOnSucceeded(
                event -> {
                    userTile.getAvatarLoadingIndicator().progressProperty().unbind();
                    userTile.getAvatarLoadingIndicator().setVisible(false);
                    userTile.getAvatar().setVisible(true);
                    Image userAvatar = getUserAvatarImageByLoginService.getValue();
                    userTile.getAvatar().setImage(userAvatar);
                    userTile.getRoot().setOnMouseClicked(event2 -> {
                        MobileApplication.getInstance().switchView(GluonApplication.USER_PROFILE_VIEW);
                        userProfilePresenter.setUserDataToPresent(user, userAvatar);
                    });
                });
        getUserAvatarImageByLoginService.start();
        userTiles.getItems().add(userTile.getRoot());
    }

    @FXML
    void reloadUsers() {
        Service<List<User>> getAllUsersService = userService.getAllUsersService();
        userTiles.getItems().clear();
        reloadSpinner.progressProperty().bind(getAllUsersService.progressProperty());
        getAllUsersService.setOnSucceeded(this::onGetAllUsersSucceed);
        reloadSpinner.setVisible(true);
        getAllUsersService.start();
    }
}
