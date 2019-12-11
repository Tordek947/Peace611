package ua.com.kl.cmathtutor.itcapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private PersonalInfo personalInfo;

    private List<Subject> subjects;

//    private List<Project> projects;
}
