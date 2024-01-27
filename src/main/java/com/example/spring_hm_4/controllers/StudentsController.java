package com.example.spring_hm_4.controllers;

import com.example.spring_hm_4.model.Student;
import com.example.spring_hm_4.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentsController {
    private StudentsService studentsService;

    /**
     * Отдаёт шаблон со списком студентов
     * @param model
     * @return
     */
    @GetMapping
    public String findAll(Model model){
        List<Student> students = studentsService.findAll();
        model.addAttribute("students", students);
        return "list-students";
    }

    /**
     *  Отдаёт представление с формой для ввода пользователя
     * @return
     */
    @GetMapping("/create")
    public String createStudent(){
        return "create-student";
    }

    /**
     * Принимает данные из формы, сохраняет студента в БД.
     * Перенаправляет на шаблон со списком студентов.
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String createStudent(Student student){
        studentsService.addStudent(student);
        return "redirect:/students";
    }

    /**
     * Принимает id студента, которого нужно удалить. Удаляет.
     * Перенаправляет на шаблон со списком студентов.
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    String deleteStudent(@PathVariable("id") int id){
        studentsService.deleteStudent(id);
        return "redirect:/students";
    }

    /**
     * Принимает id студента, данные которого нужно обновить.
     * Получает студента из БД и помещает в модель. 
     * Отправляет в шаблон с формой для редактирования данных.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id, Model model) {
        Student student = studentsService.getStudent(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    /**
     * Принимает новые данные студента, которые нужно обновить.
     * Обновляет данные по id студента.
     * Перенаправляет на шаблон со списком студентов.
     * @param student
     * @return
     */
    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute("student") Student student, @PathVariable("id") Integer id) {
        studentsService.updateStudent(student);
        return "redirect:/students";
    }
}
