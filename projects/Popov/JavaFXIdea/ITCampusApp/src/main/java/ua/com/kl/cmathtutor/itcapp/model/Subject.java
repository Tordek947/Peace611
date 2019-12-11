package ua.com.kl.cmathtutor.itcapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private String name;

    private String teacher;

    private String testType;

    private int subjectId;

    private int academicHours;

    private int mark;
}
