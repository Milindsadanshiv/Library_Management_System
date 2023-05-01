package com.First_Backend_Project.Library_Management_System.Controller;

import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.StudentRequestDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.updateMobNoOfStudentDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.FindStudentResponceDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.updateStudentMobNoResponceDTO;
import com.First_Backend_Project.Library_Management_System.Entity.Student;
import com.First_Backend_Project.Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
     StudentService studentService;
    @PostMapping("/add_Student")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO)
    {
        return studentService.addStudent(studentRequestDTO);
    }

    //delete a student by id

    //find student by id
    //find all the students
    @DeleteMapping("/deleteStudentById")
    public String deleteStudentById(@RequestParam("id") int id)
    {
        return studentService.deleteStudentById(id);
    }
    //update student by id
    @PutMapping("/updateMobNo")
    public updateStudentMobNoResponceDTO updateStudent(@RequestBody updateMobNoOfStudentDTO updateStudentMobNo) throws Exception {

       return studentService.updateStudent(updateStudentMobNo);
    }

    //find student by id
    @GetMapping("/findStudent")
    public FindStudentResponceDTO findStudent(@RequestParam("id") int id) throws Exception {
        return studentService.findStudent(id);
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }
}
