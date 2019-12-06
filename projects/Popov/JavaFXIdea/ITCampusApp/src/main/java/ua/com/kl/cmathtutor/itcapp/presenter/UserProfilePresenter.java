package ua.com.kl.cmathtutor.itcapp.presenter;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UserProfilePresenter {

    public Avatar avatar;
    public Label fullNameLabel;
    public TextField surnameInput;
    public TextField nameInput;
    public Label loginLabel;
    public TextField phoneInput;
    public Label phoneLabel;
    public DatePicker birthDatePicker;
    public Label birthLabel;
    public HBox cityInput;
    public Label cityLabel;
    public Label universityLabel;
    public Label facultyLabel;
    public Label educationYearsLabel;
    public TableView subjectsTable;
    public GridPane skillsGridPane;
    public Button saveButton;
    public Button editModeButton;
    @FXML
    private View userProfileView;

    public void initialize() {
        userProfileView.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("User Profile");
            }
        });
    }
}
