package ua.com.kl.cmathtutor.itcapp.presenter;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.control.ProgressIndicator;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import ua.com.kl.cmathtutor.itcapp.GluonApplication;

public class UsersPresenter {

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

                userTiles.getItems().forEach(tile -> tile.setOnMouseClicked(this::onUserTileClicked));
            }
        });
    }

    private void onUserTileClicked(MouseEvent mouseEvent) {
        MobileApplication.getInstance().switchView(GluonApplication.USER_PROFILE_VIEW);
    }

    @FXML
    void reloadUsers() {
    }
    
}
