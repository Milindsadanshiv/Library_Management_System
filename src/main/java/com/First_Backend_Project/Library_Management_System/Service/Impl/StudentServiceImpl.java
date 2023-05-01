package com.First_Backend_Project.Library_Management_System.Service.Impl;

import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.StudentRequestDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.RequestDTOs.updateMobNoOfStudentDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.FindStudentResponceDTO;
import com.First_Backend_Project.Library_Management_System.DTOs.ResponceDTOs.updateStudentMobNoResponceDTO;
import com.First_Backend_Project.Library_Management_System.Entity.Library_Card;
import com.First_Backend_Project.Library_Management_System.Entity.Student;
import com.First_Backend_Project.Library_Management_System.Enums.Card_Status;
import com.First_Backend_Project.Library_Management_System.Exceptions.StudentNotFoundException;
import com.First_Backend_Project.Library_Management_System.Repository.StudentRepository;
import com.First_Backend_Project.Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDTO studentRequestDTO) {
        //generate a new card for student
      Student student=new Student();
      student.setAge(studentRequestDTO.getAge());
      student.setName(studentRequestDTO.getName());
      student.setDepartment(studentRequestDTO.getDepartment());
      student.setMobNo(studentRequestDTO.getMobNo());

      Library_Card card=new Library_Card();

      card.setStatus(Card_Status.ACTIVATED);
      card.setValidTill("2026-10-10");
      card.setStudent(student);

      student.setCard(card);
      studentRepository.save(student);

      return "Student Added";

    }

    @Override
    public String deleteStudentById(int id) {
       studentRepository.deleteById(id);
       return "Student of id= "+id+" deleted";
    }

    @Override
    public updateStudentMobNoResponceDTO updateStudent(updateMobNoOfStudentDTO updateStudentMObNO) throws Exception {


        try{
            Student student=studentRepository.findById(updateStudentMObNO.getId()).get();
            student.setMobNo(updateStudentMObNO.getMobNo());
            Student updatedStudent=studentRepository.save(student);

            //prepare responce dto
            updateStudentMobNoResponceDTO UpdateStudentMobNoResponceDTO=new updateStudentMobNoResponceDTO();
            UpdateStudentMobNoResponceDTO.setMobNo(student.getMobNo());
            UpdateStudentMobNoResponceDTO.setName(student.getName());

            return UpdateStudentMobNoResponceDTO;
        }
        catch (Exception e)
        {
          throw new StudentNotFoundException("Invalid Student");
        }


    }


    public FindStudentResponceDTO findStudent(int id) throws Exception {
        Student student;
        try{
            student=studentRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw new Exception("Student id is not valid");
        }
        FindStudentResponceDTO findStudentResponceDTO=new FindStudentResponceDTO();
        findStudentResponceDTO.setDepartment(student.getDepartment());
        findStudentResponceDTO.setName(student.getName());
        findStudentResponceDTO.setMobNo(student.getMobNo());

        return findStudentResponceDTO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
