package ua.com.kl.cmathtutor.itcapp.presenter;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import org.springframework.stereotype.Controller;

/**
 * Presenter for sign-in view
 * @author Hryhorii_Popov
 *
 */
@Controller
public class SignInPresenter {

    @FXML
    private View signInView;
    @FXML
    private TextField loginInput;
    @FXML
    private PasswordField passwordInput;

    public void initialize() {
        signInView.setShowTransitionFactory(BounceInRightTransition::new);
        
        FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> System.out.println("Info"));
        fab.showOn(signInView);
        
        signInView.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("SignIn");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> 
                        System.out.println("Favorite")));
            }
        });
    }

    @FXML
    private void onLoginClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onForgotPasswordClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onSignUpClicked(ActionEvent actionEvent) {
    }
}
