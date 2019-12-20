package ua.com.kl.cmathtutor.itcapp.component;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gluonhq.charm.glisten.control.Avatar;
import com.google.common.collect.Lists;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ua.com.kl.cmathtutor.itcapp.InvisibleItemsController;
import ua.com.kl.cmathtutor.itcapp.view.UsersView;

/**
 * Component, is an object, which encapsulates both Controller and View principle.
 * Owing to this it can be reused multiple times within the other view.
 * This particular component is used to display UserModel details in shorten form within UsersView
 *
 * @author Hryhorii_Popov
 */
@Component
@Scope("prototype")
@Slf4j
@Getter
public class UserTileComponent extends InvisibleItemsController {

    @FXML
    private ProgressIndicator avatarLoadingIndicator;
    @FXML
    private Avatar avatar;
    @FXML
    private Label fullNameLabel;
    @FXML
    private Label usernameLabel;
    private HBox root;

    @PostConstruct
    private void init() {
        FXMLLoader selfLoader = new FXMLLoader();
        selfLoader.setControllerFactory(el -> this);
        selfLoader.setLocation(UsersView.class.getResource("user-tile.fxml"));

        try {
            root = selfLoader.load();
            bindVisibleProperties();
        } catch (IOException e) {
            System.out.println("Error loading user-tile.fxml");
            log.error("Exception occured during Component initialization", e);
        }
    }

    @Override
    protected Iterable<? extends Node> getAllNodesToBindVisibleProperty() {
        return Lists.newArrayList(avatar, avatarLoadingIndicator);
    }
}
