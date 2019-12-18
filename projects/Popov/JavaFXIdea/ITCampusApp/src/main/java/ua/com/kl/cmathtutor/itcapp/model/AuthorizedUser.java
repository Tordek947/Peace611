package ua.com.kl.cmathtutor.itcapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizedUser {
    private String login;
    private String name;
    private String surname;
    private EnumSet<AuthorityType> authorities;
}
