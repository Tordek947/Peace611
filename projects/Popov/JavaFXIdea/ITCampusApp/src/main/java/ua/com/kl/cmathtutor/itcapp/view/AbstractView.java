package ua.com.kl.cmathtutor.itcapp.view;

import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class AbstractView {
    protected View getViewInner(String fxmlFilename) {
        try {
            View view = FXMLLoader.load(UsersView.class.getResource(fxmlFilename + ".fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
