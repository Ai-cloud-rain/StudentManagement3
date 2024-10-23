package raisetech3.StudentManagement3.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech3.StudentManagement3.data.Student;
import raisetech3.StudentManagement3.data.StudentsCourses;
@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentsCourses> studentsCourses;

}
