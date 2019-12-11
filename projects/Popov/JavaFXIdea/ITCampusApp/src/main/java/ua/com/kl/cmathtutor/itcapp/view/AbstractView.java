package ua.com.kl.cmathtutor.itcapp.view;

import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;
import ua.com.kl.cmathtutor.itcapp.GluonApplication;

import java.io.IOException;

public class AbstractView {
    protected View getViewInner(String fxmlFilename) {
        try {
            FXMLLoader loader = GluonApplication.context.getBean(FXMLLoader.class);
            loader.setLocation(AbstractView.class.getResource(fxmlFilename + ".fxml"));
            View view = loader.load();
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
