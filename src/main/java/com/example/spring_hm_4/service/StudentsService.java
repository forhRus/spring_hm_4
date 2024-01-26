package com.example.spring_hm_4.service;

import com.example.spring_hm_4.repositories.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.spring_hm_4.model.Student;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentsService {
  private StudentsRepository studentsRepository;

  /**
   * Получить из БД список всех студентов
   * @return
   */
  public List<Student> findAll() {
    return studentsRepository.selectAll();
  }

  /**
   * Добавить в БД нового студента
   */
  public Student addStudent(Student student) {
    return studentsRepository.insert(student);
  }

  /**
   * Удалить студента
   * @param id
   */
  public void deleteStudent(int id) {
    studentsRepository.delete(id);
  }

  /**
   * Обновить данные студента
   * @param student
   */
  public void updateStudent(Student student) {
    studentsRepository.update(student);
  }

  /**
   * Получить данные студента по id
   * @param id
   * @return
   */
  public Student getStudent(int id) {
    return studentsRepository.selectUser(id);
  }
}
