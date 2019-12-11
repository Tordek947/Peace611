package ua.com.kl.cmathtutor.itcapp.service;

import javafx.concurrent.Service;
import ua.com.kl.cmathtutor.itcapp.model.UserProfile;


public interface UserProfileService {
    UserProfile getUserProfileByLogin(String login);

    Service<UserProfile> getUserProfileByLoginService(String login);
}
