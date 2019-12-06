package ua.com.kl.cmathtutor.itcapp.view;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class SignInView extends AbstractView {
    
    public View getView() {
        return getViewInner("signin");
    }
}
