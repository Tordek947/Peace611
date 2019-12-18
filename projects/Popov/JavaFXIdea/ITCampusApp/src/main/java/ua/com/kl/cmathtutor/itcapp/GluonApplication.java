package ua.com.kl.cmathtutor.itcapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.kl.cmathtutor.itcapp.view.UserProfileView;
import ua.com.kl.cmathtutor.itcapp.view.UsersView;
import ua.com.kl.cmathtutor.itcapp.view.SignInView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The main class of application
 * 
 * @author Hryhorii_Popov
 *
 */
public class GluonApplication extends MobileApplication {

    public static final String USERS_VIEW = HOME_VIEW;
    public static final String SIGN_IN_VIEW = "SignIn View";
    public static final String USER_PROFILE_VIEW = "User Profile View";
    public static AnnotationConfigApplicationContext context;

    static {
	context = new AnnotationConfigApplicationContext();
	context.register(SpringConfig.class);
	context.refresh();
    }

    @Override
    public void init() {
	addViewFactory(USERS_VIEW, () -> new UsersView().getView());
	addViewFactory(SIGN_IN_VIEW, () -> new SignInView().getView());
	addViewFactory(USER_PROFILE_VIEW, () -> new UserProfileView().getView());

	DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
	Swatch.BLUE.assignTo(scene);

	scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());
	((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon.png")));
    }
}
