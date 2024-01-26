package com.example.spring_hm_4.repositories;

import com.example.spring_hm_4.model.MagicProperties;
import com.example.spring_hm_4.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@AllArgsConstructor
public class StudentsRepository {

  private JdbcTemplate jdbc;
  private MagicProperties magic;

  /**
   * Получить список всех студентов из БД
   * @return
   */
  public List<Student> selectAll() {
    String sql = magic.getQUERY_SELECT_ALL();
    RowMapper<Student> userRowMapper = (r, i) -> {
      Student rowObject = new Student();
      rowObject.setId(r.getInt("id"));
      rowObject.setFirstName(r.getString("firstName"));
      rowObject.setLastName(r.getString("lastName"));
      rowObject.setSurName(r.getString("surName"));
      rowObject.setAge(r.getInt("age"));
      rowObject.setCourse(r.getInt("course"));
      return rowObject;
    };
    return jdbc.query(sql, userRowMapper);
  }

  /**
   * Добавить пользователя в БД
   * @param s студент
   * @return
   */
  public Student insert(Student s) {
    String sql = magic.getQUERY_INSERT_USER();
    jdbc.update(sql, s.getFirstName(), s.getLastName(), s.getSurName(),s.getAge(), s.getCourse());
    return s;
  }

  /**
   * Удалить пользователя из БД
   * @param id
   */
  public void delete(int id) {
    String sql = magic.getQUERY_DELETE_USER();
    jdbc.update(sql, id);
  }

  /**
   * Обновить данные пользователя
   * @param s
   */
  public void update(Student s) {
    String sql = magic.getQUERY_UPDATE_USER();
    jdbc.update(sql, s.getFirstName(), s.getLastName(), s.getSurName(),s.getAge(), s.getCourse(), s.getId());
  }

  /**
   * Получить данные определённого пользователя
   * @param id
   * @return
   */
  public Student selectUser(int id) {
    String sql = magic.getQUERY_SELECT_USER() + id;
    RowMapper<Student> userRowMapper = (r, i) -> {
      Student rowObject = new Student();
      rowObject.setId(r.getInt("id"));
      rowObject.setFirstName(r.getString("firstName"));
      rowObject.setLastName(r.getString("lastName"));
      rowObject.setSurName(r.getString("surName"));
      rowObject.setAge(r.getInt("age"));
      rowObject.setCourse(r.getInt("course"));
      return rowObject;
    };
    return jdbc.query(sql, userRowMapper).get(0);
  }
}
