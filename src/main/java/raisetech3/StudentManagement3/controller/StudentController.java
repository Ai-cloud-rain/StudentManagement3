package raisetech3.StudentManagement3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech3.StudentManagement3.data.Student;
import raisetech3.StudentManagement3.data.StudentsCourses;
import raisetech3.StudentManagement3.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  // ①学生情報のリストを取得するエンドポイント
  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return service.searchStudentList();
  }
  // ②コース情報のリストを取得するエンドポイント
  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentCourseList(){
    return service.searchStudentCoursesList();
  }

}
