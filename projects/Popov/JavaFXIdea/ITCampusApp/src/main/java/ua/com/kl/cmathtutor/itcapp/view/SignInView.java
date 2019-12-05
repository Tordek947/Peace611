package ua.com.kl.cmathtutor.itcapp.view;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class SignInView {
    
    public View getView() {
        try {
            View view = FXMLLoader.load(SignInView.class.getResource("signin.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
