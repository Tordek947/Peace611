package ua.com.kl.cmathtutor.itcapp.presenter;

import org.springframework.stereotype.Controller;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.google.common.collect.Lists;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import ua.com.kl.cmathtutor.itcapp.InvisibleItemsController;
import ua.com.kl.cmathtutor.itcapp.model.Subject;
import ua.com.kl.cmathtutor.itcapp.model.User;

/**
 * Presenter for user-profile view
 *
 * @author Hryhorii_Popov
 */
@Controller
public class UserProfilePresenter extends InvisibleItemsController {

    @FXML
    private Avatar avatar;
    @FXML
    private Label fullNameLabel;
    @FXML
    private TextField surnameInput;
    @FXML
    private TextField nameInput;
    @FXML
    private Label loginLabel;
    @FXML
    private TextField phoneInput;
    @FXML
    private Label phoneLabel;
    @FXML
    private DatePicker birthDatePicker;
    @FXML
    private Label birthLabel;
    @FXML
    private TextField cityInput;
    @FXML
    private Label cityLabel;
    @FXML
    private Label universityLabel;
    @FXML
    private Label facultyLabel;
    @FXML
    private Label educationYearsLabel;
    @FXML
    private TableView<Subject> subjectsTable;
    @FXML
    private GridPane skillsGridPane;
    @FXML
    private Button saveButton;
    @FXML
    private Button editModeButton;
    @FXML
    private View userProfileView;

    public void initialize() {
        userProfileView.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(
                        MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("User Profile");
                bindVisibleProperties();
                initializeButtonHandlers();
            }
        });
    }

    private void initializeButtonHandlers() {

    }

    public void setUserDataToPresent(User user, Image userAvatar) {
        System.out.println("Setting user login " + user.getLogin());
        loginLabel.setText(user.getLogin());

        nameInput.setText(user.getName());
        surnameInput.setText(user.getSurname());
        fullNameLabel.setText(user.getSurname() + " " + user.getName());
        avatar.setImage(userAvatar);
    }

    @Override
    protected Iterable<? extends Node> getAllNodesToBindVisibleProperty() {
        return Lists.newArrayList(birthDatePicker, birthLabel, cityInput, cityLabel, fullNameLabel, nameInput,
                phoneInput, phoneLabel, saveButton, surnameInput);
    }
}
