package ua.com.kl.cmathtutor.itcapp.model;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Duplicate correspondent model in ITCampus backend. For more details see
 * Swagger documentation.
 * 
 * @author Hryhorii_Popov
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo {

    private User user;

    private String phoneNumber;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String city;

    private String education;

    private String faculty;

    private Integer firstEducationYear;

    private Integer lastEducationYear;

    private Map<String, String> skills;

    private Map<String, String> languages;
}
