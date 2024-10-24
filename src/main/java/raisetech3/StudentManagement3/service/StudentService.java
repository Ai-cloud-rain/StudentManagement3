package raisetech3.StudentManagement3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech3.StudentManagement3.data.Student;
import raisetech3.StudentManagement3.data.StudentsCourses;
import raisetech3.StudentManagement3.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList(){

    return repository.search();
  }

  public List<StudentsCourses> searchStudentCoursesList(){

    return repository.searchStudentsCourses();
  }
}