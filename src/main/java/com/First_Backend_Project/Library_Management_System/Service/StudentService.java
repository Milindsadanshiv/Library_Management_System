package com.First_Backend_Project.Library_Management_System.Service;

import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.StudentRequestDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.updateMobNoOfStudentDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.FindStudentResponceDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.updateStudentMobNoResponceDTO;
import com.First_Backend_Project.Library_Management_System.Entity.Library_Card;
import com.First_Backend_Project.Library_Management_System.Entity.Student;
import com.First_Backend_Project.Library_Management_System.Enums.Card_Status;
import com.First_Backend_Project.Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface StudentService {

   public String addStudent(StudentRequestDTO studentRequestDTO);
   public String deleteStudentById(int id);
   public updateStudentMobNoResponceDTO updateStudent(updateMobNoOfStudentDTO updateStudentMObNO) throws Exception;
   public FindStudentResponceDTO findStudent(int id) throws Exception;
   public List<Student> getAllStudents();
}
