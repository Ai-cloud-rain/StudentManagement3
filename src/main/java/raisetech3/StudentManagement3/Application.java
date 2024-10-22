//課題２１
package raisetech3.StudentManagement3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// ①特定の学生情報を取得するエンドポイント
	// クエリパラメータで指定した名前の学生情報を取得する
	@GetMapping("/student")
	public String getStudent(@RequestParam String name) {
		Student student = repository.searchByName(name);
		return student.getName() + " " + student.getAge() + "歳";
	}

	// ②新規の学生情報を登録するエンドポイント
	// 指定した名前と年齢で新しい学生情報をデータベースに登録する
	@PostMapping("/student")
	public void registerStudent(@RequestParam String name, @RequestParam int age) {
		repository.registerStudent(name, age);
	}

	// ③既存の学生情報を更新するエンドポイント
	// 名前で検索した学生の年齢を更新する
	@PatchMapping("/student")
	public void updateStudent(@RequestParam String name, @RequestParam int age) {
		repository.updateStudent(name, age);
	}

	// ④特定の学生情報を削除するエンドポイント
	// 名前で指定した学生情報をデータベースから削除する
	@DeleteMapping("/student")
	public void deleteStudent(@RequestParam String name){
		repository.deleteStudent(name);
	}

	// ⑤全ての学生情報を取得するエンドポイント
	// データベースにある全ての学生情報を取得して返す
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return repository.getAllStudents();
	}
}
