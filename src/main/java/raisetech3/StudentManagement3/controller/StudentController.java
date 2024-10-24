package raisetech3.StudentManagement3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech3.StudentManagement3.controller.converter.StudentConverter;
import raisetech3.StudentManagement3.data.Student;
import raisetech3.StudentManagement3.data.StudentsCourses;
import raisetech3.StudentManagement3.domain.StudentDetail;
import raisetech3.StudentManagement3.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  // ①学生情報のリストを取得するエンドポイント
  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentCoursesList();

    return converter.convertStudentDetails(students,studentsCourses);
  }

  // ②コース情報のリストを取得するエンドポイント
  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentCourseList(){
    return service.searchStudentCoursesList();
  }

}
