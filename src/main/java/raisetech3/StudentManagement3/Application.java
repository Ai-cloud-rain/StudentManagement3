//課題２３
package raisetech3.StudentManagement3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

	// メインメソッド（アプリケーションのエントリーポイント）
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// ①学生情報のリストを取得するエンドポイント
	@GetMapping("/studentList")
	public List<Student> getStudentList() {
		return repository.search();
	}
	// ②コース情報のリストを取得するエンドポイント
	@GetMapping("/studentsCourseList")
	public List<StudentsCourses> getStudentCourseList(){
		return repository.searchStudentsCourses();
	}
}
