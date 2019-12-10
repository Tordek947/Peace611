package ua.com.kl.cmathtutor.itcapp.presenter;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.google.common.collect.Lists;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserProfilePresenter {

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
    private TableView subjectsTable;
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
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("User Profile");
                bindVisibleProperties();
            }
        });
    }

    private void bindVisibleProperties() {
        for (Node node : getAllNodesToBindVisibleProperty()) {
            node.setManaged(node.isVisible());
            node.managedProperty().bindBidirectional(node.visibleProperty());
        }
    }

    private Iterable<? extends Node> getAllNodesToBindVisibleProperty() {
        return Lists.newArrayList(birthDatePicker, birthLabel, cityInput, cityLabel, fullNameLabel, nameInput,
                phoneInput, phoneLabel, saveButton, surnameInput);
    }
}
