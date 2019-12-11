package ua.com.kl.cmathtutor.itcapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String login;

    private String name;

    private String surname;
}
