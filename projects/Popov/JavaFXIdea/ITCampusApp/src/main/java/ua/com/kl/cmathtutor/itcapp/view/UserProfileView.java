package ua.com.kl.cmathtutor.itcapp.view;

import com.gluonhq.charm.glisten.mvc.View;

public class UserProfileView extends AbstractView {

    public View getView() {
        return getViewInner("user-profile");
    }
}
