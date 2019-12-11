package ua.com.kl.cmathtutor.itcapp.component;

import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.mvc.View;
import com.google.common.collect.Lists;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.com.kl.cmathtutor.itcapp.GluonApplication;
import ua.com.kl.cmathtutor.itcapp.InvisibleItemsController;
import ua.com.kl.cmathtutor.itcapp.view.UsersView;

import javax.annotation.PostConstruct;
import java.io.IOException;

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
    private  Label fullNameLabel;
    @FXML
    private  Label usernameLabel;
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
