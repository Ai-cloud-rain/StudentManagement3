package raisetech3.StudentManagement3.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech3.StudentManagement3.data.Student;
import raisetech3.StudentManagement3.data.StudentsCourses;
import raisetech3.StudentManagement3.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  // 学生リストを取得し、30代の人のみを抽出するメソッド
  public List<Student> searchStudentList() {
    // 検索処理：全学生情報を取得
    List<Student> students = repository.search();

    // 絞り込みをする。30代の人のみを抽出する。
    // 年齢が30歳以上かつ40歳未満の学生をフィルタリング
    List<Student> filteredStudents = students.stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
        .collect(Collectors.toList());

    // 抽出したリストをコントローラーに返す。
    return filteredStudents;
  }

  // コース情報リストを取得し、「Javaコース」の情報のみを抽出するメソッド
  public List<StudentsCourses> searchStudentCoursesList() {
    // 検索処理：全コース情報を取得
    List<StudentsCourses> courses = repository.searchStudentsCourses();

    // 絞り込み検索で「Javaコース」のコース情報のみを抽出する。
    List<StudentsCourses> filteredCourses = courses.stream()
        .filter(course -> "Javaコース".equals(course.getCourseName()))
        .collect(Collectors.toList());

    // 抽出したリストをコントローラーに返す。
    return filteredCourses;
  }
}
