package raisetech3.StudentManagement3;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentRepository {

  // 特定の名前の学生情報を取得するメソッド
  @Select("SELECT * FROM student WHERE name = #{name}")
  Student searchByName(String name);

  // 新しい学生情報を登録するメソッド
  @Insert("INSERT INTO student (name, age) VALUES (#{name}, #{age})")
  void registerStudent(String name, int age);

  // 特定の名前の学生の年齢を更新するメソッド
  @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
  void updateStudent(String name, int age);

  // 特定の名前の学生情報を削除するメソッド
  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);

  // 全ての学生情報を取得するメソッド
  @Select("SELECT * FROM student")
  List<Student> getAllStudents();
}
